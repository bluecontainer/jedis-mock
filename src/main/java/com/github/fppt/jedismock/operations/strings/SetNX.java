package com.github.fppt.jedismock.operations.strings;

import com.github.fppt.jedismock.operations.AbstractRedisOperation;
import com.github.fppt.jedismock.operations.RedisCommand;
import com.github.fppt.jedismock.server.Response;
import com.github.fppt.jedismock.datastructures.Slice;
import com.github.fppt.jedismock.storage.RedisBase;

import java.util.List;

@RedisCommand("setnx")
class SetNX extends AbstractRedisOperation {
    SetNX(RedisBase base, List<Slice> params) {
        super(base, params);
    }

    protected Slice response(){
        if (base().getSlice(params().get(0)) == null) {
            base().putSlice(params().get(0), params().get(1));
            return Response.integer(1);
        }
        return Response.integer(0);
    }
}
