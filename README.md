# 一 介绍
edu-learn 仿在线教育系统 
纯属个人娱乐

演示 地址 https://www.mindskip.net/
样本页: https://www.mindskip.net/xzs.html
仿在线考试系统是一款 java + vue 的前后端分离的考试系统。

主要优点是开发、部署简单快捷、界面设计友好、代码结构清晰。支持web端和微信小程序，能覆盖到pc机和手机等设备。
支持多种部署方式：集成部署、前后端分离部署、docker部署。

# 二 用的技术栈


- springboot 
- 添加swagger2 作为接口测试平台
- mybatis
- pageHelper
- junit

#三 业务功能分析
3端

## 前端

## APP端

## 后端管理系统

### 模块分析
- 用户模块
  分为学生列表 教师列表 管理员列表
  感觉可以合成一张表
- 卷库列表
- 学科管理
- 知识点管理
- 题库管理
- 用户日志
- 消息中心
- 日志管理
- 视频管理
# 表

t_subject表记录学科
exam相关三张白哦 
exam试卷表 记录试卷的记录
exam_answer表 试卷答题的批改记录表
exam_xxxq_ss 就是用户答题记录表

question表试卷表