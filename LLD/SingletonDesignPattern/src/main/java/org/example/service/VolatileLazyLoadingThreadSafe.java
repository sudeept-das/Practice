package org.example.service;

import lombok.Getter;

@Getter
class VolatileLazyLoadingThreadSafe {
    private static volatile VolatileLazyLoadingThreadSafe singleton;
    private String value;
    private VolatileLazyLoadingThreadSafe(String value){
        this.value = value;
    }
    public static VolatileLazyLoadingThreadSafe getInstance(String value)
    {
        VolatileLazyLoadingThreadSafe result = singleton;
        if(result != null)
            return result;
        synchronized (VolatileLazyLoadingThreadSafe.class){
            if(singleton == null)
                singleton = new VolatileLazyLoadingThreadSafe(value);
        }
        return singleton;
    }

}
