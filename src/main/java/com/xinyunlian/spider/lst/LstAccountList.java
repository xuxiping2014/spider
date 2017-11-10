package com.xinyunlian.spider.lst;

import com.xinyunlian.spider.account.LstAccount;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-29 10:23
 **/
@Data
public class LstAccountList {

    public LstAccountList()
    {

    }

    private int index=0;

    private List<LstAccount> accounts=new ArrayList<LstAccount>();

    public LstAccount  next()
    {
        if(index<accounts.size())
        {
            return accounts.get(index);
        }
        else{
            return null;
        }
    }

    public boolean hasNext()
    {
        ++index;
        return index<accounts.size();
    }

}
