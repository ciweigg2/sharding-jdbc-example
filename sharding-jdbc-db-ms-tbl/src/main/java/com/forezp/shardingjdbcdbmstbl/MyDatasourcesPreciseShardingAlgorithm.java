package com.forezp.shardingjdbcdbmstbl;


import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 自定义分片算法 数据库逻辑可以将配置逻辑放在redis然后读取 可以根据id规则或者根据创建日期等等做分片的呀
 * 
 * @author Ciwei
 *
 */
public class MyDatasourcesPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		for (String datasources : availableTargetNames) {
			if (datasources.endsWith(String.valueOf(shardingValue.getValue() % 2))) {
				return datasources;
			}
		}
		throw new IllegalArgumentException();
	}

}
