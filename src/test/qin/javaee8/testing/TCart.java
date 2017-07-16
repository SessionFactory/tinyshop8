package qin.javaee8.testing;

import qin.tinyshop8.utils.ShopBaseSupport;

public class TCart implements ShopBaseSupport
{
    private static final long serialVersionUID = -1546304661772367766L;

    public TCart()
    {
    }

    public TCart(String name)
    {
        this.name = name;
    }

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}