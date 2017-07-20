package qin.javaee8.testing;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain.GoodsCategory;
import qin.tinyshop8.utils.ShopBaseSupport;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

public class SaveGoods implements ShopBaseSupport,
          SessionBasic
{
    //分类
    @Test
    public void goodsCategory() throws Exception
    {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setCategoryAlias("alias");
        goodsCategory.setCategoryName("name");
        goodsCategory.setCategorySort(1);

        //language=MySQL
        String sql = "SELECT * FROM tiny_goods_category";
        StringBuilder sb = new StringBuilder();

        sb.append("package qin.javaee8.testing;\n" +
                            "\n" +
                            "import org.junit.Test;\n" +
                            "import qin.javaee8.core.SessionBasic;\n" +
                            "import qin.tinyshop8.domain.*;\n" +
                            "import qin.tinyshop8.utils.ShopBaseSupport;\n" +
                            "\n" +
                            "import java.util.ArrayList;\n" +
                            "import java.util.List;\n" +
                            "\n" +
                            "public class SaveGoodsCategory implements ShopBaseSupport,\n" +
                            "          SessionBasic\n" +
                            "{\n" +
                            "    @Test\n" +
                            "    public void save() throws Exception\n" +
                            "    {");

        List<Object[]> list = session.createNativeQuery(sql).list();

        for (int i = 0; i < list.size(); i++)
        {
            Object[] objects = list.get(i);

            sb.append("        GoodsCategory goodsCategory" + i + " = new GoodsCategory();\n" +
                                "        goodsCategory" + i + ".setTypeAlias(\"" + objects[2] + "\");\n" +
                                "        goodsCategory" + i + ".setTypeName(\"" + objects[1] + "\");\n" +
                                "        goodsCategory" + i + ".setTypeSort(" + objects[9] + ");\n");
        }

        for (int i = 0; i < list.size(); i++)
        {
            sb.append("session.save(goodsCategory" + i + ");");
        }

        sb.append("transaction.commit();\n}}");

        FileWriter fileWriter = new FileWriter(new File("" +
                                                                  "D:\\idea2017WK\\tinyshop8\\src\\test\\qin\\javaee8\\testing\\" +
                                                                  "SaveGoodsCategory.java"));
        fileWriter.write(sb.toString());
        fileWriter.flush();

        System.out.println();
    }

    //@Test
    public void save_goods() throws Exception
    {
        System.out.println(Double.valueOf("65.0"));

        //language=MySQL
        String sql = "SELECT * FROM tiny_goods";
        List list = session.createNativeQuery(sql).list();

        StringBuilder sb = new StringBuilder();
        StringBuilder after = new StringBuilder();

        int i = 0;
        String basePath = "http://localhost/tinyshopV3.0_data/";

        sb.append("package qin.javaee8.testing;\n" +
                            "\n" +
                            "import qin.javaee8.core.SessionBasic;\nimport org.junit.*;" +
                            "import qin.tinyshop8.utils.ShopBaseSupport;\n" +
                            "\n" +
                            "public class SaveGoodsInfo implements ShopBaseSupport,\n" +
                            "          SessionBasic{@Test public void save() throws Exception {");

        for (Iterator iterator = list.iterator(); iterator.hasNext(); i++)
        {
            Object[] objects = (Object[]) iterator.next();

            sb
                      .append("Goods goods")
                      .append(i)
                      .append(" = new Goods();\n")
                      .append("                goods" + i + ".setGoodsName(\"")
                      .append(objects[1])
                      .append("\");\n")
                      .append("                goods" + i + ".setGoodsProNo(\"")
                      .append(objects[5])
                      .append("\");\n")
                      .append("                goods" + i + ".setGoodsNo(\"")
                      .append(objects[4])
                      .append("\");\n")
                      .append("                goods" + i + ".setGoodsStoreNums(")
                      .append(objects[17])
                      .append(");\n")
                      .append("                goods" + i + ".setGoodsWeight(\"")
                      .append(objects[22])
                      .append("\");\n")
                      .append("                goods" + i + ".setGoodsSellPrice(Double.valueOf(\"")
                      .append(objects[13])
                      .append("\"));\n")
                      .append("                goods" + i + ".setGoodsMarketPrice(Double.valueOf(\"")
                      .append(objects[14])
                      .append("\"));\n")
                      .append("                goods" + i + ".setGoodsCostPrice(Double.valueOf(\"")
                      .append(objects[15])
                      .append("\"));").append("\n");

            sb
                      .append("   List<String> goodsImages" + i + " = new ArrayList<>();\n")
                      .append("            goodsImages" + i + ".add(basePath + \"")
                      .append(objects[10])
                      .append("\");\n")
                      .append("            goods" + i + ".setGoodsImgs(goodsImages" + i + ");");

            after
                      .append("session.save(goods")
                      .append(i)
                      .append(");");
        }

        after.append("transaction.commit();}}");

        FileWriter fileWriter = new FileWriter(new File("" +
                                                                  "D:\\idea2017WK\\tinyshop8\\src\\test\\qin\\javaee8\\testing\\SaveGoodsInfo.java"));
        fileWriter.write(sb.append("\n").append(after).append("\n").toString());
        fileWriter.flush();

        //System.out.println(list.size());
    }
}


















