package com.echarts.echartsutil.util;

import sun.misc.BASE64Encoder;
import org.apache.commons.collections4.CollectionUtils;


import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Mr丶s
 * @date 2020/7/8 3:57 下午
 * @description
 */
public class EchartsUtil {

    //TODO 需要配置此路径（绝对路径）
    private static final String JSpath = "C:\\Users\\admin\\Desktop\\echart\\echarts-convert\\echarts-convert1.js";


    public static void main(String[] args) {
        String imgName = "C:/echart/" + UUID.randomUUID().toString().substring(0, 4) + ".png ";
//        String option = "{xAxis: {type: 'category',data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']},yAxis: {type: 'value'},series: [{data: [820, 932, 901, 934, 1290, 1330, 1320],type: 'bar'},itemStyle:{color:'#ffff00'}]}";
//        String option = "{xAxis: {type: 'category',data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']},yAxis: {type: 'value'},series: [{\n" +
//                "            name: '直接访问',\n" +
//                "            type: 'bar',\n" +
//                "            data: [320, 332, 301, 334, 390, 330, 320]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            name: '邮件营销',\n" +
//                "            type: 'bar',\n" +
//                "            stack: '广告',\n" +
//                "            data: [120, 132, 101, 134, 90, 230, 210]\n" +
//                "        },\n" +
//                "        {\n" +
//                "            name: '联盟广告',\n" +
//                "            type: 'bar',\n" +
//                "            stack: '广告',\n" +
//                "            data: [220, 182, 191, 234, 290, 330, 310]\n" +
//                "        }]}";
//        String option = "{\"title\":{\"text\":\"渠道图\",\"subtext\":\"渠道统计\",\"x\":\"CENTER\"},\"toolbox\": {\"feature\": {\"saveAsImage\": {\"show\": true,}}},\"tooltip\": {\"show\": true},\"legend\": {\"data\":[\"直接访问\",\"邮件营销\",\"联盟广告\",\"视频广告\",\"搜索引擎\"]}, \"series\":[{\"name\":\"访问来源\",\"type\":\"pie\",\"radius\": '55%',\"center\": ['50%', '60%'],\"data\":[{\"value\":335, \"name\":\"直接访问\"},{\"value\":310, \"name\":\"邮件营销\"},{\"value\":234, \"name\":\"联盟广告\"},{\"value\":135, \"name\":\"视频广告\"},{\"value\":1548, \"name\":\"搜索引擎\"}]}]}\n";
//        String option = "{\"title\":{\"text\":\"销售图\",\"subtext\":\"销售统计\",\"x\":\"left\"},\"toolbox\": {\"feature\": {\"saveAsImage\": {\"show\": true,}}},\"tooltip\": {\"show\": true},\"legend\": {\"data\":['销量']},\"xAxis\" : [{ \"type\" : \"category\",\"data\" : [\"衬衫\",\"羊毛衫\",\"雪纺衫\",\"裤子\",\"高跟鞋\",\"袜子\"]}],\"yAxis\" : [{\"type\" : \"value\"}],\"series\" : [{\"name\":\"销量\",\"type\":\"bar\",\"data\":[5, 20, 40, 10, 10, 20]}]}\n";
//         String option = "{\n" +
//                 "            legend: {\n" +
//                 "                data: ['提交问题数', '修复问题数' ]\n" +
//                 "            },\n" +
//                 "            xAxis: {\n" +
//                 "                type: 'category',\n" +
//                 "                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']\n" +
//                 "            },\n" +
//                 "            yAxis: {\n" +
//                 "                name:'问题数',\n" +
//                 "                type: 'value'\n" +
//                 "            },\n" +
//                 "            series: [\n" +
//                 "                {\n" +
//                 "                    name: '提交问题数',\n" +
//                 "                    type: 'bar',\n" +
//                 "                    color:'#49baf4',\n" +
//                 "                    data: [120, 132, 101, 134, 90, 230, 210]\n" +
//                 "                },\n" +
//                 "                {\n" +
//                 "                    name: '修复问题数',\n" +
//                 "                    type: 'line',\n" +
//                 "                    color:'#fec32d',\n" +
//                 "                    data: [220, 182, 191, 234, 290, 330, 310]\n" +
//                 "                },\n" +
//                 "            ]\n" +
//                 "        }";
//
//
//         //String options = "test";
//         String base64Img = generateEChart(option, 1600, 900);
//         System.out.println(base64Img);

// ['Mon', 'Tue', 'Tue', 'Thu', 'Fri', 'Sat', 'Sun' ]

        List<String> listx = Arrays.asList("Mon", "Tue", "Tue", "Thu", "Fri", "Sat", "Sun");
        String c = convertListToString(listx);

        List<Object> data = Arrays.asList(120, 132, 101, 134, 90, 230, 210);

        List<Object> data1 = Arrays.asList(220, 182, 191, 234, 290, 330, 310);

        List<Object> data2 = Arrays.asList(150, 232, 201, 154, 190, 330, 410);

        String line = monthlyStatistics(c, data, data1, data2);
        System.out.println(line);


    }

    /**
     * 将List<String>集合 转化为String
     * 如{"aaa","bbb"} To 'aaa','bbb'
     */
    public static String convertListToString(List<String> strlist) {
        StringBuffer sb = new StringBuffer();
        if (CollectionUtils.isNotEmpty(strlist)) {
            for (int i = 0; i < strlist.size(); i++) {
                if (i == 0) {
                    sb.append("['").append(strlist.get(i)).append("'");
                } else {
                    sb.append(",").append("'").append(strlist.get(i)).append("'");
                }
                if (i == strlist.size() - 1) {
                    sb.append("]");
                }
            }
        }
        return sb.toString();

    }

    /**
     * echarts生成图片
     *
     * @param options options内容
     * @param width   图片宽度
     * @param height  图片高度
     * @return
     */
    public static String generateEChart(String options, int width, int height) {

        String fileName = "test-" + UUID.randomUUID().toString().substring(0, 8) + ".png";
        String imgPath = "C:/echart/" + fileName;

        //数据json
        String dataPath = writeFile(options);
        try {
            //文件路径（路径+文件名）
            File file = new File(imgPath);
            if (!file.exists()) {
                //文件不存在则创建文件，先创建目录
                File dir = new File(file.getParent());
                dir.mkdirs();
                file.createNewFile();
            }
            //TODO 需要配置此路径（绝对路径）
            String pjs = "C:\\Users\\admin\\Desktop\\echart\\phantomjs-2.1.1-windows\\bin\\";
            //执行phantomjs生成echarts报表图片
            //TODO win及linux执行路径可能不同
            String cmd = pjs + "phantomjs " + JSpath + " -infile " + dataPath + " -outfile " + imgPath + " -width " + width + " -height " + height;
            System.out.println(cmd);
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                //System.out.println(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            String base64Img = ImageToBase64(imgPath);

            //deleteFile(imgPath);
            //deleteFile(dataPath);
            return base64Img.replaceAll("\\s*", "");
        }
    }

    /**
     * 通过options生成json文件
     *
     * @param options
     * @return
     */
    public static String writeFile(String options) {
        String dataPath = "C:/echart/data/data" + UUID.randomUUID().toString().substring(0, 8) + ".json";
        try {
            /* 写入Txt文件 */
            // 相对路径，如果没有则要建立一个新的output.txt文件
            File writename = new File(dataPath);
            if (!writename.exists()) {
                //文件不存在则创建文件，先创建目录
                File dir = new File(writename.getParent());
                dir.mkdirs();
                writename.createNewFile(); // 创建新文件
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(options); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataPath;
    }

    /**
     * 图片文件转为base64
     *
     * @param imgPath
     */
    private static String ImageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(Objects.requireNonNull(data));
    }

    /**
     * 删除文件
     *
     * @param pathname
     * @return
     * @throws IOException
     */
    public static boolean deleteFile(String pathname) {
        boolean result = false;
        File file = new File(pathname);
        if (file.exists()) {
            file.delete();
            result = true;
            System.out.println("文件已经被成功删除");
        }
        return result;
    }


    /**
     * 问题处理月统计
     *
     * @param lineX         x轴值
     * @param newFeedback   新增反馈
     * @param submitProblem 提交问题
     * @param fixProblem    修复问题
     * @return
     */
    private static String monthlyStatistics(String lineX, List<Object> newFeedback, List<Object> submitProblem, List<Object> fixProblem) {
        String monthlyStatistics = "{\n" +
                "            legend: {\n" +
                "                data: ['新增反馈数', '提交问题数', '修复问题数' ]\n" +
                "            },\n" +
                "            xAxis: {\n" +
                "                type: 'category',\n" +
                "                data: " + lineX +
                "            },\n" +
                "            yAxis: {\n" +
                "                name:'问题数',\n" +
                "                type: 'value'\n" +
                "            },\n" +
                "            series: [\n" +
                "                {\n" +
                "                    name: '新增反馈数',\n" +
                "                    type: 'line',\n" +
                "                    color:'#50bcf7',\n" +
                "                    data: " + newFeedback.toString() +
                "                },\n" +
                "                {\n" +
                "                    name: '提交问题数',\n" +
                "                    type: 'line',\n" +
                "                    color:'#ffc42e',\n" +
                "                    data: " + submitProblem.toString() +
                "                },\n" +
                "                {\n" +
                "                    name: '修复问题数',\n" +
                "                    type: 'line',\n" +
                "                    color:'#13b574',\n" +
                "                    data: " + fixProblem.toString() +
                "                },\n" +
                "            ]\n" +
                "        }";

        return monthlyStatistics;
    }

    /**
     * DI值统计
     *
     * @param lineX
     * @param legacyDI
     * @param closedDI
     * @return
     */
    private static String diStatistics(String lineX, List<Object> legacyDI, List<Object> closedDI) {
        String diStatistics = "{\n" +
                "            legend: {\n" +
                "                data: ['遗留DI值', '已关闭DI值' ]\n" +
                "            },\n" +
                "            xAxis: {\n" +
                "                type: 'category',\n" +
                "                data: " + lineX +
                "            },\n" +
                "            yAxis: {\n" +
                "                name:'数量',\n" +
                "                type: 'value'\n" +
                "            },\n" +
                "            series: [\n" +
                "                {\n" +
                "                    name: '遗留DI值',\n" +
                "                    type: 'bar',\n" +
                "                    color:'#ff7b79',\n" +
                "                    stack: 'DI值',\n" +
                "                    data: " + legacyDI.toString() +
                "                },\n" +
                "                {\n" +
                "                    name: '已关闭DI值',\n" +
                "                    type: 'bar',\n" +
                "                    color:'#49baf4',\n" +
                "                    stack: 'DI值',\n" +
                "                    data: " + closedDI.toString() +
                "                },\n" +
                "            ]\n" +
                "        }";

        return diStatistics;
    }


    /**
     * 机型提交与修复
     *
     * @param lineX
     * @param submitNumber
     * @param repairNumber
     * @return
     */
    private static String modelSubmitRepair(String lineX, List<Object> submitNumber, List<Object> repairNumber) {
        String modelSubmitRepair = "{\n" +
                "            legend: {\n" +
                "                data: ['提交问题数', '修复问题数' ]\n" +
                "            },\n" +
                "            xAxis: {\n" +
                "                type: 'category',\n" +
                "                data: " + lineX +
                "            },\n" +
                "            yAxis: {\n" +
                "                name:'问题数',\n" +
                "                type: 'value'\n" +
                "            },\n" +
                "            series: [\n" +
                "                {\n" +
                "                    name: '提交问题数',\n" +
                "                    type: 'bar',\n" +
                "                    color:'#49baf4'，\n" +
                "                    data: " + submitNumber.toString() +
                "                },\n" +
                "                {\n" +
                "                    name: '修复问题数',\n" +
                "                    type: 'line',\n" +
                "                    color:'#fec32d',\n" +
                "                    data: " + repairNumber.toString() +
                "                },\n" +
                "            ]\n" +
                "        }";

        return modelSubmitRepair;
    }

    /**
     * 机型提交、修复、修复率
     *
     * @param lineX
     * @param submitNumber
     * @param repairRateNumber
     * @return
     */
    private static String modelSubmitRepairRate(String lineX, List<Object> submitNumber, List<Object> repairNumber, List<Object> repairRateNumber) {
        String modelSubmitRepairRate = "{\n" +
                "            legend: {\n" +
                "                data: ['提交问题数', '修复问题数','修复率' ]\n" +
                "            },\n" +
                "            xAxis: {\n" +
                "                type: 'category',\n" +
                "                data: " + lineX +
                "            },\n" +
                "            yAxis: [\n" +
                "                {\n" +
                "                    type: 'value',\n" +
                "                    name: '问题数',\n" +
                "                    max: 100,\n" +
                "                },\n" +
                "                {\n" +
                "                    type: 'value',\n" +
                "                    name: '修复率（%）',\n" +
                "                    max: 100,\n" +
                "                }\n" +
                "            ],\n" +
                "            series: [\n" +
                "                {\n" +
                "                    name: '提交问题数',\n" +
                "                    type: 'bar',\n" +
                "                    color:'#ff7b79',\n" +
                "                    data: " + submitNumber.toString() +
                "                },\n" +
                "                {\n" +
                "                    name: '修复问题数',\n" +
                "                    barGap:'10%',\n" +
                "                    type: 'bar',\n" +
                "                    color:'#49baf4',\n" +
                "                    data: " + repairNumber.toString() +
                "                },\n" +
                "                {\n" +
                "                    name: '修复率',\n" +
                "                    type: 'line',\n" +
                "                    yAxisIndex: 1,\n" +
                "                    color:'#fcd266',\n" +
                "                    data: " + repairRateNumber.toString() +
                "                },\n" +
                "            ]\n" +
                "        }";

        return modelSubmitRepairRate;
    }

}
