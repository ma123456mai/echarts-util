此工具类解决java后端生成echarts报表


关于option可由于前端生成，后端填入值即可


使用前EchartsUtil中：
        JSpath、pjs 默认路径需要使用绝对路径，才可执行成功！
        windows使用phantomjs需要在系统变量中配置，相关执行路径 例：C:\Users\admin\Desktop\echart\phantomjs-2.1.1-windows\bin\
        linux使用phantomjs需要中文字体支持：  在centos中执行：yum install bitmap-fonts bitmap-fonts-cjk
                                          在ubuntu中执行：sudo apt-get install xfonts-wqy
        
        
注：phantomjs 各版本下载地址 https://phantomjs.org/download.html
   