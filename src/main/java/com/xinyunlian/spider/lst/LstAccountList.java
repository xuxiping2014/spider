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
        accounts.add(new LstAccount("13575788541","123456xuxiping","宁波"));
        accounts.add(new LstAccount("hualichun_2009","huali123456","宁波"));
        accounts.add(new LstAccount("陶1234562013","tct051313","山东省"));
        accounts.add(new LstAccount("yuanzhong18","zy062215","重庆市"));
        accounts.add(new LstAccount("zhuyanjun2525","zhujun2815312","河南省"));
        accounts.add(new LstAccount("18031541966","HBwangjinghui1990","河北省"));
        accounts.add(new LstAccount("18605733221","852599aa","嘉兴市"));
        accounts.add(new LstAccount("zhangyang0246","yang0202","杭州市"));
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
