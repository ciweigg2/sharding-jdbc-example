package com.forezp.shardingjdbcdbmstbl;


import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 自定义分片算法
 * 
 * @author yinjihuan
 *
 */
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

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
