package com.xinyunlian.spider.ancc;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthException extends  Exception {
    public AuthException(String message)
    {
        super(message);
    }

}
