# LTPCloud-SDK-RxJava

[哈大语言云（LTP-Cloud）](https://www.ltp-cloud.com)SDK，基于Retrofit，RxJava

> 语言云提供了NLP Web API，用于分析文本，分析模式包括：
> * 分词
> * 词性标注
> * 命名实体识别
> * 依存句法分析
> * 语义依存分析
> * 语义角色标注

## 开始使用

因为调用Web API需要API Key

[注册](https://www.ltp-cloud.com/accounts/register/)语言云账号，然后在[个人中心](https://www.ltp-cloud.com/dashboard/)获取你的API Key

```
final String API_KEY = "YourApiKey";
LTPService service = LTP.getService();

service.getWordSegmentation(API_KEY, "今晚打老虎")
    .subscribe(new Consumer<WSResult[][][]>() {

        @Override
        public void accept(WSResult[][][] wsResults) throws Exception {
            for (WSResult[][] paragraph: wsResults) {
                for (WSResult[] sentence: paragraph ) {
                    for (WSResult word : sentence) {
                        System.out.println(word);
                    }
                }
            }
        }

    });
```


## 安装
此项目在JitPack上发布

在项目根目录build.gradle修改
```
allprojects {
    repositories {
        ...
        maven { url 'https://www.jitpack.io' }    //加入这行
    }
}
```

在模块build.gradle加上
```
dependencies {
    compile 'com.github.lvsecoto:LTPCloudSDK-RxJava-Retrofit:1.0.0'

    compile 'com.squareup.retrofit2:retrofit:2.3.0'
    compile 'com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0'
    compile 'com.squareup.retrofit2:converter-gson:2.3.0'
}
```

## 运行测试

测试用例需要API Key，它定义在测试文件夹内的成员`package com.yjy.lib.APIKey.APK_KEY`

因涉及隐私安全问题，值为空，需要自己定义

**请勿将自己的API key 提交到远程版本库！**

## 使用文档
### 获取文本分析结果

下面的方法将返回一个Observer<XXResult>对象，然后就可以用RxJava的事件/订阅方式处理了

分词
```
service.getWordSegmentation(APIKey.API_KEY, "今晚打老虎");
```

词性标注
```
service.getPartOfSpeech(APIKey.API_KEY, "今晚打老虎");
```

命名实体识别
```
service.getNamedEntityRecognition(APIKey.API_KEY, "武松打老虎");
```

依存句法分析
```
service.getDependencyParsing(APIKey.API_KEY, "今晚打老虎");
```

语义依存分析
```
service.getSemanticDependencyParsing(APIKey.API_KEY, "今晚打老虎");
```

### 对文本分析结果的处理

Web API返回结果已经被封装成不同的Been对象`XXResult`

> `getWordSegmentation`返回的是`WSResult[][][]`

注意返回的是一个三维数组，每一维度分别代表段落，句子，词语

> `wsResult[0]`可获取第一段落，`wsResult[0][0]`，获取第一段的第一个句子，`wsResult[0][0][1]`，获取第一段的第一个句子第二个词，

### 工具类
进一步封装的工具类，今后会添加更多

#### WordSegmentation
可对句子进行分词，并将结果转换为`List<String>`。可用于模糊搜索

```
WordSegmentation wordSegmentation;
wordSegmentation = new WordSegmentation(API_KEY);

wordSegmentation.segment("今晚打老虎")
    .subscribe(new Consumer<List<String>>() {

        @Override
        public void accept(List<String> words) throws Exception {
            StringBuilder reg = new StringBuilder();

            for (String word : words) {
                reg.append(word);
                reg.append("|");
            }

            reg.deleteCharAt(reg.length()-1);

            // 只要句子中带有“今晚”，“打”，“老虎”，mPattern就能匹配
            mPattern = Pattern.compile(reg.toString());
        }

    });
```

### 错误处理

#### HTTP 401 UNAUTHORIZED

授权错误，请确保你的API KEY是正确的

