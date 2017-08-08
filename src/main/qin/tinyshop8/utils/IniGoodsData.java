package qin.tinyshop8.utils;

import org.springframework.stereotype.Repository;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain.Goods;
import qin.tinyshop8.domain.GoodsBrand;
import qin.tinyshop8.domain.GoodsCategory;
import qin.tinyshop8.domain.GoodsSpec;
import qin.tinyshop8.domain.GoodsType;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化表中数据
 *
 * @author qinzhengying
 * @since 1.8 2017/7/16
 */
@Repository
@Deprecated
public class IniGoodsData implements ShopBaseSupport,
          SessionBasic
{
    private static final long serialVersionUID = 3413302406972383482L;

    public void ini() throws Exception
    {
        try
        {

            GoodsType goodsType1 = new GoodsType("手机产品",
                                                 "a:1:{i:0;a:6:{s:2:\"id\";s:10:\"1073741824\";s:7:\"type_id\";s:1:\"1\";s:4:\"name\";s:12:\"屏幕尺寸\";s:9:\"show_type\";s:1:\"1\";s:4:\"sort\";s:1:\"0\";s:6:\"values\";a:5:{i:0;a:4:{s:2:\"id\";s:1:\"1\";s:7:\"attr_id\";s:10:\"1073741824\";s:4:\"name\";s:18:\"5.6英寸及以上\";s:4:\"sort\";s:1:\"0\";}i:1;a:4:{s:2:\"id\";s:1:\"2\";s:7:\"attr_id\";s:10:\"1073741824\";s:4:\"name\";s:13:\"5.5-5.0英寸\";s:4:\"sort\";s:1:\"1\";}i:2;a:4:{s:2:\"id\";s:1:\"3\";s:7:\"attr_id\";s:10:\"1073741824\";s:4:\"name\";s:13:\"4.9-4.1英寸\";s:4:\"sort\";s:1:\"2\";}i:3;a:4:{s:2:\"id\";s:1:\"4\";s:7:\"attr_id\";s:10:\"1073741824\";s:4:\"name\";s:13:\"4.0-3.1英寸\";s:4:\"sort\";s:1:\"3\";}i:4;a:4:{s:2:\"id\";s:1:\"5\";s:7:\"attr_id\";s:10:\"1073741824\";s:4:\"name\";s:18:\"3.0英寸及以下\";s:4:\"sort\";s:1:\"4\";}}}}");
            GoodsType goodsType2 = new GoodsType("笔记本产品",
                                                 "a:4:{i:0;a:6:{s:2:\"id\";s:10:\"1073741825\";s:7:\"type_id\";s:1:\"2\";s:4:\"name\";s:6:\"尺寸\";s:9:\"show_type\";s:1:\"1\";s:4:\"sort\";s:1:\"0\";s:6:\"values\";a:8:{i:0;a:4:{s:2:\"id\";s:1:\"6\";s:7:\"attr_id\";s:10:\"1073741825\";s:4:\"name\";s:19:\"10.1英寸及以下\";s:4:\"sort\";s:1:\"0\";}i:1;a:4:{s:2:\"id\";s:1:\"7\";s:7:\"attr_id\";s:10:\"1073741825\";s:4:\"name\";s:8:\"11英寸\";s:4:\"sort\";s:1:\"1\";}i:2;a:4:{s:2:\"id\";s:1:\"8\";s:7:\"attr_id\";s:10:\"1073741825\";s:4:\"name\";s:8:\"12英寸\";s:4:\"sort\";s:1:\"2\";}i:3;a:4:{s:2:\"id\";s:1:\"9\";s:7:\"attr_id\";s:10:\"1073741825\";s:4:\"name\";s:8:\"13英寸\";s:4:\"sort\";s:1:\"3\";}i:4;a:4:{s:2:\"id\";s:2:\"10\";s:7:\"attr_id\";s:10:\"1073741825\";s:4:\"name\";s:8:\"14英寸\";s:4:\"sort\";s:1:\"4\";}i:5;a:4:{s:2:\"id\";s:2:\"11\";s:7:\"attr_id\";s:10:\"1073741825\";s:4:\"name\";s:8:\"15英寸\";s:4:\"sort\";s:1:\"5\";}i:6;a:4:{s:2:\"id\";s:2:\"12\";s:7:\"attr_id\";s:10:\"1073741825\";s:4:\"name\";s:17:\"16英寸-17英寸\";s:4:\"sort\";s:1:\"6\";}i:7;a:4:{s:2:\"id\";s:2:\"13\";s:7:\"attr_id\";s:10:\"1073741825\";s:4:\"name\";s:14:\"17英寸以上\";s:4:\"sort\";s:1:\"7\";}}}i:1;a:6:{s:2:\"id\";s:10:\"1073741826\";s:7:\"type_id\";s:1:\"2\";s:4:\"name\";s:6:\"触控\";s:9:\"show_type\";s:1:\"1\";s:4:\"sort\";s:1:\"1\";s:6:\"values\";a:3:{i:0;a:4:{s:2:\"id\";s:2:\"14\";s:7:\"attr_id\";s:10:\"1073741826\";s:4:\"name\";s:12:\"普通触控\";s:4:\"sort\";s:1:\"0\";}i:1;a:4:{s:2:\"id\";s:2:\"15\";s:7:\"attr_id\";s:10:\"1073741826\";s:4:\"name\";s:12:\"变形触控\";s:4:\"sort\";s:1:\"1\";}i:2;a:4:{s:2:\"id\";s:2:\"16\";s:7:\"attr_id\";s:10:\"1073741826\";s:4:\"name\";s:9:\"非触控\";s:4:\"sort\";s:1:\"2\";}}}i:2;a:6:{s:2:\"id\";s:10:\"1073741827\";s:7:\"type_id\";s:1:\"2\";s:4:\"name\";s:10:\" 处理器\";s:9:\"show_type\";s:1:\"1\";s:4:\"sort\";s:1:\"2\";s:6:\"values\";a:6:{i:0;a:4:{s:2:\"id\";s:2:\"17\";s:7:\"attr_id\";s:10:\"1073741827\";s:4:\"name\";s:7:\"i3Intel\";s:4:\"sort\";s:1:\"0\";}i:1;a:4:{s:2:\"id\";s:2:\"18\";s:7:\"attr_id\";s:10:\"1073741827\";s:4:\"name\";s:7:\"i5Intel\";s:4:\"sort\";s:1:\"1\";}i:2;a:4:{s:2:\"id\";s:2:\"19\";s:7:\"attr_id\";s:10:\"1073741827\";s:4:\"name\";s:7:\"i7Intel\";s:4:\"sort\";s:1:\"2\";}i:3;a:4:{s:2:\"id\";s:2:\"20\";s:7:\"attr_id\";s:10:\"1073741827\";s:4:\"name\";s:5:\"A6AMD\";s:4:\"sort\";s:1:\"3\";}i:4;a:4:{s:2:\"id\";s:2:\"21\";s:7:\"attr_id\";s:10:\"1073741827\";s:4:\"name\";s:5:\"A8AMD\";s:4:\"sort\";s:1:\"4\";}i:5;a:4:{s:2:\"id\";s:2:\"22\";s:7:\"attr_id\";s:10:\"1073741827\";s:4:\"name\";s:6:\"A10AMD\";s:4:\"sort\";s:1:\"5\";}}}i:3;a:6:{s:2:\"id\";s:10:\"1073741828\";s:7:\"type_id\";s:1:\"2\";s:4:\"name\";s:6:\"显卡\";s:9:\"show_type\";s:1:\"1\";s:4:\"sort\";s:1:\"3\";s:6:\"values\";a:2:{i:0;a:4:{s:2:\"id\";s:2:\"23\";s:7:\"attr_id\";s:10:\"1073741828\";s:4:\"name\";s:15:\"性能级独显\";s:4:\"sort\";s:1:\"0\";}i:1;a:4:{s:2:\"id\";s:2:\"24\";s:7:\"attr_id\";s:10:\"1073741828\";s:4:\"name\";s:15:\"玩家级独显\";s:4:\"sort\";s:1:\"1\";}}}}");
            GoodsType goodsType3 = new GoodsType("平板", "");
            GoodsType goodsType4 = new GoodsType("女式衬衫",
                                                 "a:2:{i:0;a:6:{s:2:\"id\";s:10:\"1073741829\";s:7:\"type_id\";s:1:\"4\";s:4:\"name\";s:6:\"袖长\";s:9:\"show_type\";s:1:\"1\";s:4:\"sort\";s:1:\"0\";s:6:\"values\";a:7:{i:0;a:4:{s:2:\"id\";s:2:\"25\";s:7:\"attr_id\";s:10:\"1073741829\";s:4:\"name\";s:6:\"长袖\";s:4:\"sort\";s:1:\"0\";}i:1;a:4:{s:2:\"id\";s:2:\"26\";s:7:\"attr_id\";s:10:\"1073741829\";s:4:\"name\";s:6:\"短袖\";s:4:\"sort\";s:1:\"1\";}i:2;a:4:{s:2:\"id\";s:2:\"27\";s:7:\"attr_id\";s:10:\"1073741829\";s:4:\"name\";s:9:\"七分袖\";s:4:\"sort\";s:1:\"2\";}i:3;a:4:{s:2:\"id\";s:2:\"28\";s:7:\"attr_id\";s:10:\"1073741829\";s:4:\"name\";s:6:\"无袖\";s:4:\"sort\";s:1:\"3\";}i:4;a:4:{s:2:\"id\";s:2:\"29\";s:7:\"attr_id\";s:10:\"1073741829\";s:4:\"name\";s:9:\"九分袖\";s:4:\"sort\";s:1:\"4\";}i:5;a:4:{s:2:\"id\";s:2:\"30\";s:7:\"attr_id\";s:10:\"1073741829\";s:4:\"name\";s:16:\"五分袖/中袖\";s:4:\"sort\";s:1:\"5\";}i:6;a:4:{s:2:\"id\";s:2:\"31\";s:7:\"attr_id\";s:10:\"1073741829\";s:4:\"name\";s:6:\"其它\";s:4:\"sort\";s:1:\"6\";}}}i:1;a:6:{s:2:\"id\";s:10:\"1073741830\";s:7:\"type_id\";s:1:\"4\";s:4:\"name\";s:6:\"面料\";s:9:\"show_type\";s:1:\"1\";s:4:\"sort\";s:1:\"1\";s:6:\"values\";a:10:{i:0;a:4:{s:2:\"id\";s:2:\"32\";s:7:\"attr_id\";s:10:\"1073741830\";s:4:\"name\";s:3:\"棉\";s:4:\"sort\";s:1:\"0\";}i:1;a:4:{s:2:\"id\";s:2:\"33\";s:7:\"attr_id\";s:10:\"1073741830\";s:4:\"name\";s:6:\"涤纶\";s:4:\"sort\";s:1:\"1\";}i:2;a:4:{s:2:\"id\";s:2:\"34\";s:7:\"attr_id\";s:10:\"1073741830\";s:4:\"name\";s:6:\"真丝\";s:4:\"sort\";s:1:\"2\";}i:3;a:4:{s:2:\"id\";s:2:\"35\";s:7:\"attr_id\";s:10:\"1073741830\";s:4:\"name\";s:6:\"绸缎\";s:4:\"sort\";s:1:\"3\";}i:4;a:4:{s:2:\"id\";s:2:\"36\";s:7:\"attr_id\";s:10:\"1073741830\";s:4:\"name\";s:7:\" 雪纺\";s:4:\"sort\";s:1:\"4\";}i:5;a:4:{s:2:\"id\";s:2:\"37\";s:7:\"attr_id\";s:10:\"1073741830\";s:4:\"name\";s:20:\"亚麻/大麻/汉麻\";s:4:\"sort\";s:1:\"5\";}i:6;a:4:{s:2:\"id\";s:2:\"38\";s:7:\"attr_id\";s:10:\"1073741830\";s:4:\"name\";s:14:\" 腈纶/化纤\";s:4:\"sort\";s:1:\"6\";}i:7;a:4:{s:2:\"id\";s:2:\"39\";s:7:\"attr_id\";s:10:\"1073741830\";s:4:\"name\";s:9:\"莫代尔\";s:4:\"sort\";s:1:\"7\";}i:8;a:4:{s:2:\"id\";s:2:\"40\";s:7:\"attr_id\";s:10:\"1073741830\";s:4:\"name\";s:7:\" 锦纶\";s:4:\"sort\";s:1:\"8\";}i:9;a:4:{s:2:\"id\";s:2:\"41\";s:7:\"attr_id\";s:10:\"1073741830\";s:4:\"name\";s:6:\"其它\";s:4:\"sort\";s:1:\"9\";}}}}");
            GoodsType goodsType5 = new GoodsType("男式衬衫",
                                                 "a:2:{i:0;a:6:{s:2:\"id\";s:10:\"1073741831\";s:7:\"type_id\";s:1:\"5\";s:4:\"name\";s:6:\"袖长\";s:9:\"show_type\";s:1:\"1\";s:4:\"sort\";s:1:\"0\";s:6:\"values\";a:5:{i:0;a:4:{s:2:\"id\";s:2:\"42\";s:7:\"attr_id\";s:10:\"1073741831\";s:4:\"name\";s:6:\"长袖\";s:4:\"sort\";s:1:\"0\";}i:1;a:4:{s:2:\"id\";s:2:\"43\";s:7:\"attr_id\";s:10:\"1073741831\";s:4:\"name\";s:6:\"短袖\";s:4:\"sort\";s:1:\"1\";}i:2;a:4:{s:2:\"id\";s:2:\"44\";s:7:\"attr_id\";s:10:\"1073741831\";s:4:\"name\";s:9:\"五分袖\";s:4:\"sort\";s:1:\"2\";}i:3;a:4:{s:2:\"id\";s:2:\"45\";s:7:\"attr_id\";s:10:\"1073741831\";s:4:\"name\";s:9:\"七分袖\";s:4:\"sort\";s:1:\"3\";}i:4;a:4:{s:2:\"id\";s:2:\"46\";s:7:\"attr_id\";s:10:\"1073741831\";s:4:\"name\";s:6:\"无袖\";s:4:\"sort\";s:1:\"4\";}}}i:1;a:6:{s:2:\"id\";s:10:\"1073741832\";s:7:\"type_id\";s:1:\"5\";s:4:\"name\";s:6:\"领子\";s:9:\"show_type\";s:1:\"1\";s:4:\"sort\";s:1:\"1\";s:6:\"values\";a:5:{i:0;a:4:{s:2:\"id\";s:2:\"47\";s:7:\"attr_id\";s:10:\"1073741832\";s:4:\"name\";s:6:\"立领\";s:4:\"sort\";s:1:\"0\";}i:1;a:4:{s:2:\"id\";s:2:\"48\";s:7:\"attr_id\";s:10:\"1073741832\";s:4:\"name\";s:6:\"圆领\";s:4:\"sort\";s:1:\"1\";}i:2;a:4:{s:2:\"id\";s:2:\"49\";s:7:\"attr_id\";s:10:\"1073741832\";s:4:\"name\";s:6:\"心领\";s:4:\"sort\";s:1:\"2\";}i:3;a:4:{s:2:\"id\";s:2:\"50\";s:7:\"attr_id\";s:10:\"1073741832\";s:4:\"name\";s:6:\"无领\";s:4:\"sort\";s:1:\"3\";}i:4;a:4:{s:2:\"id\";s:2:\"51\";s:7:\"attr_id\";s:10:\"1073741832\";s:4:\"name\";s:6:\"常规\";s:4:\"sort\";s:1:\"4\";}}}}");

            session.save(goodsType1);
            session.save(goodsType2);
            session.save(goodsType3);
            session.save(goodsType4);
            session.save(goodsType5);

            ////////////////////////////////////////////

            GoodsSpec goodsSpec1 = new GoodsSpec("系统", "文字", "");
            GoodsSpec goodsSpec2 = new GoodsSpec("颜色", "文字", "");
            GoodsSpec goodsSpec3 = new GoodsSpec("硬盘", "文字", "");
            GoodsSpec goodsSpec4 = new GoodsSpec("系统", "文字", "");
            GoodsSpec goodsSpec5 = new GoodsSpec("尺寸", "文字", "");
            GoodsSpec goodsSpec6 = new GoodsSpec("尺码", "文字", "");

            session.save(goodsSpec1);
            session.save(goodsSpec2);
            session.save(goodsSpec3);
            session.save(goodsSpec4);
            session.save(goodsSpec5);
            session.save(goodsSpec6);

            ////////////////////////////////////////////

            Goods goods0 = new Goods();
            goods0.setGoodsName("【原封正品 移动4G公开版特价】Apple/苹果 iPhone 5S 苹果5S手机");
            goods0.setGoodsProNo("AG0012320_1");
            goods0.setGoodsNo("AG0012320");
            goods0.setGoodsStoreNums(36);
            goods0.setGoodsWeight("300");
            goods0.setGoodsSellPrice(Double.valueOf("4898.0"));
            goods0.setGoodsMarketPrice(Double.valueOf("5000.0"));
            goods0.setGoodsCostPrice(Double.valueOf("4700.0"));
            List<String> goodsImages0 = new ArrayList<>();
            goodsImages0.add(basePath + "data/uploads/2014/04/29/870c43499b99862429287c2d4119fef6.jpg");
            goods0.setGoodsImgs(goodsImages0);
            Goods goods1 = new Goods();
            goods1.setGoodsName("小米手机3国内性价比最强机");
            goods1.setGoodsProNo("X20140120567_1");
            goods1.setGoodsNo("X20140120567");
            goods1.setGoodsStoreNums(36);
            goods1.setGoodsWeight("300");
            goods1.setGoodsSellPrice(Double.valueOf("1799.0"));
            goods1.setGoodsMarketPrice(Double.valueOf("1999.0"));
            goods1.setGoodsCostPrice(Double.valueOf("1799.0"));
            List<String> goodsImages1 = new ArrayList<>();
            goodsImages1.add(basePath + "data/uploads/2014/04/29/bee3fc7f0746b54f51fc5f1a2e7a38e3.jpg");
            goods1.setGoodsImgs(goodsImages1);
            Goods goods2 = new Goods();
            goods2.setGoodsName("MacBook Air");
            goods2.setGoodsProNo("M20140102654_1");
            goods2.setGoodsNo("M20140102654");
            goods2.setGoodsStoreNums(24);
            goods2.setGoodsWeight("1080");
            goods2.setGoodsSellPrice(Double.valueOf("6288.0"));
            goods2.setGoodsMarketPrice(Double.valueOf("6388.0"));
            goods2.setGoodsCostPrice(Double.valueOf("6200.0"));
            List<String> goodsImages2 = new ArrayList<>();
            goodsImages2.add(basePath + "data/uploads/2014/04/29/6b33dafad4bb8752240cf2d3ab066be8.jpg");
            goods2.setGoodsImgs(goodsImages2);
            Goods goods3 = new Goods();
            goods3.setGoodsName("Samsung GALAXY S5 4G 联通定制版 G9006V");
            goods3.setGoodsProNo("SX201401023465_1");
            goods3.setGoodsNo("SX201401023465");
            goods3.setGoodsStoreNums(24);
            goods3.setGoodsWeight("300");
            goods3.setGoodsSellPrice(Double.valueOf("5299.0"));
            goods3.setGoodsMarketPrice(Double.valueOf("5399.0"));
            goods3.setGoodsCostPrice(Double.valueOf("5200.0"));
            List<String> goodsImages3 = new ArrayList<>();
            goodsImages3.add(basePath + "data/uploads/2014/04/29/d6e93371fdcfae0890fe519fdeb50129.jpg");
            goods3.setGoodsImgs(goodsImages3);
            Goods goods4 = new Goods();
            goods4.setGoodsName("联想 ThinkPad X1 Carbon X1 Carbon 3443-1N1 i7 4G 笔记本");
            goods4.setGoodsProNo("L20140203432");
            goods4.setGoodsNo("L20140203432");
            goods4.setGoodsStoreNums(23);
            goods4.setGoodsWeight("3405");
            goods4.setGoodsSellPrice(Double.valueOf("16699.0"));
            goods4.setGoodsMarketPrice(Double.valueOf("16799.0"));
            goods4.setGoodsCostPrice(Double.valueOf("16000.0"));
            List<String> goodsImages4 = new ArrayList<>();
            goodsImages4.add(basePath + "data/uploads/2014/04/29/8f551833e1ab9568186641fe4b5b0101.jpg");
            goods4.setGoodsImgs(goodsImages4);
            Goods goods5 = new Goods();
            goods5.setGoodsName("Apple/苹果 配备 Retina 显示屏的 MacBook Pro ME865CH/A笔电脑 1");
            goods5.setGoodsProNo("AP20140101787_1");
            goods5.setGoodsNo("AP20140101787");
            goods5.setGoodsStoreNums(24);
            goods5.setGoodsWeight("1570");
            goods5.setGoodsSellPrice(Double.valueOf("9288.0"));
            goods5.setGoodsMarketPrice(Double.valueOf("9298.0"));
            goods5.setGoodsCostPrice(Double.valueOf("9200.0"));
            List<String> goodsImages5 = new ArrayList<>();
            goodsImages5.add(basePath + "data/uploads/2014/04/30/b8f4125b967911e08f7115f8d2b3f684.jpg");
            goods5.setGoodsImgs(goodsImages5);
            Goods goods6 = new Goods();
            goods6.setGoodsName("Apple/苹果 iPhone 5C电信版 苹果5c 正品行货");
            goods6.setGoodsProNo("AP20140101788_1");
            goods6.setGoodsNo("AP20140101788");
            goods6.setGoodsStoreNums(72);
            goods6.setGoodsWeight("300");
            goods6.setGoodsSellPrice(Double.valueOf("3367.0"));
            goods6.setGoodsMarketPrice(Double.valueOf("3899.0"));
            goods6.setGoodsCostPrice(Double.valueOf("3367.0"));
            List<String> goodsImages6 = new ArrayList<>();
            goodsImages6.add(basePath + "data/uploads/2014/04/30/62527b26f1afbe204f247b72d1f20c2d.jpg");
            goods6.setGoodsImgs(goodsImages6);
            Goods goods7 = new Goods();
            goods7.setGoodsName(" Apple/苹果 iPhone 4s 8G 苹果4S手机");
            goods7.setGoodsProNo("AP20140101786_1");
            goods7.setGoodsNo("AP20140101786");
            goods7.setGoodsStoreNums(24);
            goods7.setGoodsWeight("400");
            goods7.setGoodsSellPrice(Double.valueOf("2479.0"));
            goods7.setGoodsMarketPrice(Double.valueOf("3488.0"));
            goods7.setGoodsCostPrice(Double.valueOf("2479.0"));
            List<String> goodsImages7 = new ArrayList<>();
            goodsImages7.add(basePath + "data/uploads/2014/04/30/f31a00b4e0f6617378095a8c1bfb00c9.jpg");
            goods7.setGoodsImgs(goodsImages7);
            Goods goods8 = new Goods();
            goods8.setGoodsName("小米手机2S");
            goods8.setGoodsProNo("X20140120566_1");
            goods8.setGoodsNo("X20140120566");
            goods8.setGoodsStoreNums(60);
            goods8.setGoodsWeight("400");
            goods8.setGoodsSellPrice(Double.valueOf("1299.0"));
            goods8.setGoodsMarketPrice(Double.valueOf("1499.0"));
            goods8.setGoodsCostPrice(Double.valueOf("1299.0"));
            List<String> goodsImages8 = new ArrayList<>();
            goodsImages8.add(basePath + "data/uploads/2014/04/30/f3ccdd27d2000e3f9255a7e3e2c48800.jpg");
            goods8.setGoodsImgs(goodsImages8);
            Goods goods9 = new Goods();
            goods9.setGoodsName("Apple/苹果 ipad air  WIFI iPad Air平板黑预售白现货");
            goods9.setGoodsProNo("AP20140101785_1");
            goods9.setGoodsNo("AP20140101785");
            goods9.setGoodsStoreNums(48);
            goods9.setGoodsWeight("700");
            goods9.setGoodsSellPrice(Double.valueOf("3399.0"));
            goods9.setGoodsMarketPrice(Double.valueOf("4900.0"));
            goods9.setGoodsCostPrice(Double.valueOf("3999.0"));
            List<String> goodsImages9 = new ArrayList<>();
            goodsImages9.add(basePath + "data/uploads/2014/04/30/95fc43a276b4706c1eb6be35a460dcc9.jpg");
            goods9.setGoodsImgs(goodsImages9);
            Goods goods10 = new Goods();
            goods10.setGoodsName("BRIOSO格子衬衫 女 长袖2014春装新款女装修身韩版大码百搭衬衣潮");
            goods10.setGoodsProNo("NS20140504123_1");
            goods10.setGoodsNo("NS20140504123");
            goods10.setGoodsStoreNums(191);
            goods10.setGoodsWeight("200");
            goods10.setGoodsSellPrice(Double.valueOf("49.0"));
            goods10.setGoodsMarketPrice(Double.valueOf("199.0"));
            goods10.setGoodsCostPrice(Double.valueOf("40.0"));
            List<String> goodsImages10 = new ArrayList<>();
            goodsImages10.add(basePath + "data/uploads/2014/05/04/6a63f7365e4430b5d07791fd32c66500.jpg");
            goods10.setGoodsImgs(goodsImages10);
            Goods goods11 = new Goods();
            goods11.setGoodsName("白衬衫女短袖2014新款夏装女衬衣大码工作服工装韩版女士衬衫职业");
            goods11.setGoodsProNo("NS20140504121_1");
            goods11.setGoodsNo("NS20140504121");
            goods11.setGoodsStoreNums(219);
            goods11.setGoodsWeight("200");
            goods11.setGoodsSellPrice(Double.valueOf("55.0"));
            goods11.setGoodsMarketPrice(Double.valueOf("110.0"));
            goods11.setGoodsCostPrice(Double.valueOf("50.0"));
            List<String> goodsImages11 = new ArrayList<>();
            goodsImages11.add(basePath + "data/uploads/2014/05/04/f81d28ad7c32504c0af3a8c44eec681e.jpg");
            goods11.setGoodsImgs(goodsImages11);
            Goods goods12 = new Goods();
            goods12.setGoodsName("春夏装新款2014长袖白衬衫女短袖雪纺韩版大码女装打底衫职业衬衣");
            goods12.setGoodsProNo("NS20140504122_1");
            goods12.setGoodsNo("NS20140504122");
            goods12.setGoodsStoreNums(616);
            goods12.setGoodsWeight("200");
            goods12.setGoodsSellPrice(Double.valueOf("79.0"));
            goods12.setGoodsMarketPrice(Double.valueOf("238.0"));
            goods12.setGoodsCostPrice(Double.valueOf("70.0"));
            List<String> goodsImages12 = new ArrayList<>();
            goodsImages12.add(basePath + "data/uploads/2014/05/04/fb84a52b8da8869e478a236ed10172b8.jpg");
            goods12.setGoodsImgs(goodsImages12);
            Goods goods13 = new Goods();
            goods13.setGoodsName("夏天职业衬衫女装正装短袖衬衫工装女寸衫韩版白领工作服白衬衣女");
            goods13.setGoodsProNo("NS20140504120_1");
            goods13.setGoodsNo("NS20140504120");
            goods13.setGoodsStoreNums(264);
            goods13.setGoodsWeight("200");
            goods13.setGoodsSellPrice(Double.valueOf("49.0"));
            goods13.setGoodsMarketPrice(Double.valueOf("108.0"));
            goods13.setGoodsCostPrice(Double.valueOf("40.0"));
            List<String> goodsImages13 = new ArrayList<>();
            goodsImages13.add(basePath + "data/uploads/2014/05/04/da175403c79047247a25e76ec8c4913a.jpg");
            goods13.setGoodsImgs(goodsImages13);
            Goods goods14 = new Goods();
            goods14.setGoodsName("职业女装纯棉内搭白色寸衫水钻领子带钻翻领衬衫搭配小西装打底衫");
            goods14.setGoodsProNo("NS20140504124_1");
            goods14.setGoodsNo("NS20140504124");
            goods14.setGoodsStoreNums(88);
            goods14.setGoodsWeight("200");
            goods14.setGoodsSellPrice(Double.valueOf("45.0"));
            goods14.setGoodsMarketPrice(Double.valueOf("68.0"));
            goods14.setGoodsCostPrice(Double.valueOf("40.0"));
            List<String> goodsImages14 = new ArrayList<>();
            goodsImages14.add(basePath + "data/uploads/2014/05/04/b1dcd910f2d270c11d91668ecfbf7302.jpg");
            goods14.setGoodsImgs(goodsImages14);
            Goods goods15 = new Goods();
            goods15.setGoodsName("时尚潮流 牛仔衬衫 男 长袖韩版时尚复古磨白衬衫男春夏外套包邮");
            goods15.setGoodsProNo("MS20140504120_1");
            goods15.setGoodsNo("MS20140504120");
            goods15.setGoodsStoreNums(110);
            goods15.setGoodsWeight("200");
            goods15.setGoodsSellPrice(Double.valueOf("58.0"));
            goods15.setGoodsMarketPrice(Double.valueOf("199.0"));
            goods15.setGoodsCostPrice(Double.valueOf("50.0"));
            List<String> goodsImages15 = new ArrayList<>();
            goodsImages15.add(basePath + "data/uploads/2014/05/04/19579466f48282ec37548040b0c69bb3.jpg");
            goods15.setGoodsImgs(goodsImages15);
            Goods goods16 = new Goods();
            goods16.setGoodsName("2014夏装长袖男士格子衬衣拼接波点修身休闲衬衫衫青春百搭潮热卖");
            goods16.setGoodsProNo("MS20140504121_1");
            goods16.setGoodsNo("MS20140504121");
            goods16.setGoodsStoreNums(264);
            goods16.setGoodsWeight("200");
            goods16.setGoodsSellPrice(Double.valueOf("78.0"));
            goods16.setGoodsMarketPrice(Double.valueOf("278.0"));
            goods16.setGoodsCostPrice(Double.valueOf("70.0"));
            List<String> goodsImages16 = new ArrayList<>();
            goodsImages16.add(basePath + "data/uploads/2014/05/04/a56ab48abdf9aefdef5fd16abb44d02c.jpg");
            goods16.setGoodsImgs(goodsImages16);
            Goods goods17 = new Goods();
            goods17.setGoodsName("2014春装新款长袖衬衫男 韩版修身灯芯绒波点衬衫男士衬衫上衣潮");
            goods17.setGoodsProNo("MS20140504122_1");
            goods17.setGoodsNo("MS20140504122");
            goods17.setGoodsStoreNums(66);
            goods17.setGoodsWeight("200");
            goods17.setGoodsSellPrice(Double.valueOf("65.0"));
            goods17.setGoodsMarketPrice(Double.valueOf("198.0"));
            goods17.setGoodsCostPrice(Double.valueOf("60.0"));
            List<String> goodsImages17 = new ArrayList<>();
            goodsImages17.add(basePath + "data/uploads/2014/05/04/16615175a6eff3846c20d4e68100ed70.jpg");
            goods17.setGoodsImgs(goodsImages17);
            Goods goods18 = new Goods();
            goods18.setGoodsName("2014春装男款格子长袖男衬衫 休闲衬衣潮");
            goods18.setGoodsProNo("MS20140504123_1");
            goods18.setGoodsNo("MS20140504123");
            goods18.setGoodsStoreNums(220);
            goods18.setGoodsWeight("200");
            goods18.setGoodsSellPrice(Double.valueOf("35.0"));
            goods18.setGoodsMarketPrice(Double.valueOf("75.0"));
            goods18.setGoodsCostPrice(Double.valueOf("30.0"));
            List<String> goodsImages18 = new ArrayList<>();
            goodsImages18.add(basePath + "data/uploads/2014/05/04/9bd757b51fc75afd17475b667a042599.jpg");
            goods18.setGoodsImgs(goodsImages18);
            Goods goods19 = new Goods();
            goods19.setGoodsName("复古风唐装男士长袖衬衫 韩版修身灯芯绒盘扣莲花秀男式休闲衬衣");
            goods19.setGoodsProNo("MS20140504124_1");
            goods19.setGoodsNo("MS20140504124");
            goods19.setGoodsStoreNums(96);
            goods19.setGoodsWeight("200");
            goods19.setGoodsSellPrice(Double.valueOf("76.0"));
            goods19.setGoodsMarketPrice(Double.valueOf("126.0"));
            goods19.setGoodsCostPrice(Double.valueOf("70.0"));
            List<String> goodsImages19 = new ArrayList<>();
            goodsImages19.add(basePath + "data/uploads/2014/05/04/451b95af03616fd150e78fdc84a22378.jpg");
            goods19.setGoodsImgs(goodsImages19);
            session.save(goods0);
            session.save(goods1);
            session.save(goods2);
            session.save(goods3);
            session.save(goods4);
            session.save(goods5);
            session.save(goods6);
            session.save(goods7);
            session.save(goods8);
            session.save(goods9);
            session.save(goods10);
            session.save(goods11);
            session.save(goods12);
            session.save(goods13);
            session.save(goods14);
            session.save(goods15);
            session.save(goods16);
            session.save(goods17);
            session.save(goods18);
            session.save(goods19);

            ////////////////////////////////////////////

            GoodsCategory goodsCategory0 = new GoodsCategory();
            goodsCategory0.setCategoryAlias("pc_phone");
            goodsCategory0.setCategoryName("电脑、手机");
            goodsCategory0.setCategorySort(2);
            GoodsCategory goodsCategory1 = new GoodsCategory();
            goodsCategory1.setCategoryAlias("computer");
            goodsCategory1.setCategoryName("笔记本");
            goodsCategory1.setCategorySort(2);
            GoodsCategory goodsCategory2 = new GoodsCategory();
            goodsCategory2.setCategoryAlias("phone");
            goodsCategory2.setCategoryName("手机");
            goodsCategory2.setCategorySort(2);
            GoodsCategory goodsCategory3 = new GoodsCategory();
            goodsCategory3.setCategoryAlias("tache");
            goodsCategory3.setCategoryName("平板");
            goodsCategory3.setCategorySort(1);
            GoodsCategory goodsCategory4 = new GoodsCategory();
            goodsCategory4.setCategoryAlias("apparel");
            goodsCategory4.setCategoryName("服饰");
            goodsCategory4.setCategorySort(3);
            GoodsCategory goodsCategory5 = new GoodsCategory();
            goodsCategory5.setCategoryAlias("women");
            goodsCategory5.setCategoryName("女装");
            goodsCategory5.setCategorySort(1);
            GoodsCategory goodsCategory6 = new GoodsCategory();
            goodsCategory6.setCategoryAlias("shrit");
            goodsCategory6.setCategoryName("衬衫");
            goodsCategory6.setCategorySort(1);
            GoodsCategory goodsCategory7 = new GoodsCategory();
            goodsCategory7.setCategoryAlias("men");
            goodsCategory7.setCategoryName("男式");
            goodsCategory7.setCategorySort(1);
            GoodsCategory goodsCategory8 = new GoodsCategory();
            goodsCategory8.setCategoryAlias("men_shrit");
            goodsCategory8.setCategoryName("衬衫");
            goodsCategory8.setCategorySort(1);
            session.save(goodsCategory0);
            session.save(goodsCategory1);
            session.save(goodsCategory2);
            session.save(goodsCategory3);
            session.save(goodsCategory4);
            session.save(goodsCategory5);
            session.save(goodsCategory6);
            session.save(goodsCategory7);
            session.save(goodsCategory8);

            ////////////////////////////////////////////

            GoodsBrand g1 = new GoodsBrand("联想", "http://www.lenovo.com.cn/", 1);
            GoodsBrand g2 = new GoodsBrand("小米", "http://www.mi.com/", 1);
            GoodsBrand g3 = new GoodsBrand("苹果", "http://www.apple.com/", 1);
            GoodsBrand g4 = new GoodsBrand("三星", "http://www.samsung.com/", 1);

            session.save(g1);
            session.save(g2);
            session.save(g3);
            session.save(g4);

            transaction.commit();
        }
        catch (Exception ex)
        {
            superLogInfo("初始化音乐信息失败!");
        }
    }
}