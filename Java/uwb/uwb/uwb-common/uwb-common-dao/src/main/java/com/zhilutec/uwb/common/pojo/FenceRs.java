package com.zhilutec.uwb.common.pojo;


import com.zhilutec.uwb.entity.Fence;

import java.util.List;

public class FenceRs {
    private Integer type;
    private List<Fence> fences;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Fence> getFences() {
        return fences;
    }

    public void setFences(List<Fence> fences) {
        this.fences = fences;
    }

    @Override
    public String toString() {
        return "FenceRs{" +
                "type=" + type +
                ", fences=" + fences +
                '}';
    }
}
