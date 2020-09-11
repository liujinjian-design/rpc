# 详细设计
## 背景
新的营销方式，目的为创造新的收入点，提前锁定顾客订单，提升店铺单量。[详细描述](https://nos.hsmob.com/apps/external/30)
## 改造点
### 接口改造点
+ 券模板
    - 券模板subName(卡券副标题)作为名称备注使用
    - subName支持更新，涉及接口[更新卡模板](http://showdoc.weimob.com/index.php?s=/189&page_id=6023)、[券模板->更新卡模板](http://showdoc.weimob.com/index.php?s=/189&page_id=9171)
+ 券包相关
    - [券包创建](http://showdoc.weimob.com/index.php?s=/189&page_id=5561)新增remark(名称备注)字段(card_package表新增字段remark,type为varchar(256))
    - [券包修改](http://showdoc.weimob.com/index.php?s=/189&page_id=5832)新增remark字段，支持修改
    - [券包查询](http://showdoc.weimob.com/index.php?s=/189&page_id=5557)新增remark字段
    - [券包回收](http://showdoc.weimob.com/index.php?s=/189&page_id=12291)支持预发券包回收库存与限领
+ 券投放
    - [券投放](http://showdoc.weimob.com/index.php?s=/189&page_id=4338)支持投放已添加到券包中的券
