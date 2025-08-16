将中文转为拼音。  
不依赖任何三方库，只需引入几KB即可实现，有良好的兼容性，不挑运行环境。


## 在线体验

[https://res.zvo.cn/pinyin/demo.html](https://res.zvo.cn/pinyin/demo.html)


## JavaScript 使用

````
<script src="https://res.zvo.cn/pinyin/pinyin.js"></script>
<script>
console.log(pinyin.convert('你好'));
</script>
````

## JavaSDK
它提供了java中使用的能力  

#### 1. maven 引入
````
<dependency>
    <groupId>cn.zvo.translate</groupId>
    <artifactId>chinese.to.pinyin</artifactId>
    <version>2.0</version>
</dependency>
````

#### 2. 使用
````
System.out.println(Pinyin.convert("你好"));
````

## 其他说明

起初为 [自动写代码](https://github.com/xnx3/writecode) 系统做的一个配套支持，实现也是网上找的，自己进行了完善优化，然后发现都整理好了，不发出来有点浪费，于是乎...

## 联系方式
整理完善者：管雷鸣  
微信：xnx3com  
交流QQ群：279789411
