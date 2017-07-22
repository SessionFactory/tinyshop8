package _2test;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain8.GoodsType8;
import qin.tinyshop8.utils.ShopBaseSupport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SearchGoodsType implements ShopBaseSupport,
          SessionBasic
{
    String getChildren(GoodsType8 goodsType8, int value) throws IOException
    {
        String path = "D:\\idea2017WK\\tinyshop8\\WebContent\\html\\mobile.html";

        StringBuilder s = new StringBuilder();

        String head = "<!DOCTYPE html>\n" +
                  "<html lang=\"en\">\n" +
                  "<head>\n" +
                  "    <meta charset=\"UTF-8\">\n" +
                  "    <title>Title</title>\n" +
                  "    <script type=\"text/javascript\" src=\"http://localhost/jsLib2017/easyui152/jquery.min.js\"></script>\n" +
                  "    <script type=\"text/javascript\" src=\"http://localhost/jsLib2017/easyui152/jquery.easyui.min.js\"></script>\n" +
                  "    <link rel=\"stylesheet\" href=\"http://localhost/jsLib2017/easyui152/themes/bootstrap/easyui.css\">\n" +
                  "    <script type=\"text/javascript\" src=\"http://localhost/jsLib2017/easyui152/locale/easyui-lang-zh_CN.js\"></script>\n" +
                  "    <link rel=\"stylesheet\" href=\"http://localhost/jsLib2017/easyui152/themes/color.css\">\n" +
                  "    <link rel=\"stylesheet\" href=\"http://localhost/jsLib2017/easyui152/themes/icon.css\">\n" +
                  "</head>\n" +
                  "<body>\n";

        if (value == 0)
        {
            s.append(head);
        }

        s.append("<ul class=\"easyui-tree\">\n" +
                           "    <li>        <span>" + goodsType8.getTypeName() + "</span>");

        if (goodsType8.getChildrenSet() != null)
        {
            if (goodsType8.getChildrenSet().size() > 0)
            {
                int i = 0;
                s.append("<ul>");
                Set<GoodsType8> childrenSet = goodsType8.getChildrenSet();
                for (Iterator<GoodsType8> c = childrenSet.iterator(); c.hasNext(); )
                {
                    ++i;
                    GoodsType8 children = c.next();
                    s.append("<li>" + children.getTypeName() + "</li>");
                    s.append(getChildren(children, i));
                }
                s.append("</ul>");
            }
        }

        if (value == 0)
        {
            s.append("    </li>\n" +
                               "</ul>\n</body>\n" +
                               "</html>");
        }

        FileWriter fileWriter = new FileWriter(new File(path));
        fileWriter.write(s.toString());
        fileWriter.flush();

        return s.toString();
    }

    @Test
    public void getChildrenTest() throws Exception
    {
        List<GoodsType8> goodsType8List = session
                  .createQuery("from GoodsType8 where parentType.id=null")
                  .list();

        StringBuilder sb = new StringBuilder();

        for (Iterator<GoodsType8> it = goodsType8List.iterator(); it.hasNext(); )
        {
            GoodsType8 goodsType8 = it.next();
            sb.append(getChildren(goodsType8, 0));
        }

        String path = "D:\\idea2017WK\\tinyshop8\\src\\mobile.txt";
        FileWriter fileWriter = new FileWriter(new File(path));
        fileWriter.write(sb.toString());
        fileWriter.flush();
    }

    //@Test
    public void search() throws Exception
    {
        List<GoodsType8> goodsType8List = session
                  .createQuery("from GoodsType8 where parentType.id=null")
                  .list();

        for (Iterator<GoodsType8> it = goodsType8List.iterator(); it.hasNext(); )
        {
            GoodsType8 goodsType8 = it.next();
            superLogInfo(goodsType8.getTypeName());
            Set<GoodsType8> childrenSet = goodsType8.getChildrenSet();
            for (Iterator<GoodsType8> c = childrenSet.iterator(); c.hasNext(); )
            {
                GoodsType8 children = c.next();
                superLogInfo("|------" + children.getTypeName());
            }
        }

    }


}