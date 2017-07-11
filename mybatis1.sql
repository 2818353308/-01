/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : mybatis1

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2017-07-07 08:53:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attention`
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention` (
  `attention_id` int(11) NOT NULL AUTO_INCREMENT,
  `by_user_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`attention_id`),
  KEY `被关注人的id` (`by_user_id`),
  KEY `关注人id` (`user_id`),
  CONSTRAINT `attention_ibfk_1` FOREIGN KEY (`by_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attention_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attention
-- ----------------------------
INSERT INTO `attention` VALUES ('1', '2', '1');
INSERT INTO `attention` VALUES ('2', '2', '3');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `c_content` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `被评论的帖子id` (`p_id`),
  KEY `评论人id` (`user_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `paper` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '1', '我是班长，我怕谁');
INSERT INTO `comment` VALUES ('2', '1', '2', '我就是班长');
INSERT INTO `comment` VALUES ('3', '3', '1', '就这智商还要他干什么？拿个棍子再继续往粪坑里怼怼');
INSERT INTO `comment` VALUES ('5', '5', '2', '我也这么认为----该你点一万个赞');
INSERT INTO `comment` VALUES ('6', '5', '2', 'cvgdf');
INSERT INTO `comment` VALUES ('7', '3', '2', 'fdsf');
INSERT INTO `comment` VALUES ('8', '17', '1', '爱上大嘎达');

-- ----------------------------
-- Table structure for `fabulous`
-- ----------------------------
DROP TABLE IF EXISTS `fabulous`;
CREATE TABLE `fabulous` (
  `fabulous_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`fabulous_id`),
  KEY `点赞人` (`user_id`),
  KEY `被赞的帖子` (`p_id`),
  CONSTRAINT `fabulous_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `paper` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fabulous_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fabulous
-- ----------------------------
INSERT INTO `fabulous` VALUES ('1', '1', '1');
INSERT INTO `fabulous` VALUES ('2', '1', '2');
INSERT INTO `fabulous` VALUES ('3', '1', '3');
INSERT INTO `fabulous` VALUES ('5', '1', '5');
INSERT INTO `fabulous` VALUES ('6', '2', '5');
INSERT INTO `fabulous` VALUES ('7', '2', '3');
INSERT INTO `fabulous` VALUES ('8', '2', '2');
INSERT INTO `fabulous` VALUES ('9', '1', '13');
INSERT INTO `fabulous` VALUES ('10', '3', '2');
INSERT INTO `fabulous` VALUES ('11', '3', '10');
INSERT INTO `fabulous` VALUES ('12', '3', '9');

-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `f_content` varchar(255) DEFAULT NULL,
  `f_name` varchar(255) DEFAULT NULL,
  `f_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', '1', '页面好炫', '521521', 'asdf@qq.com');

-- ----------------------------
-- Table structure for `gpaper`
-- ----------------------------
DROP TABLE IF EXISTS `gpaper`;
CREATE TABLE `gpaper` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_type` varchar(255) DEFAULT NULL,
  `g_content` varchar(500) DEFAULT NULL,
  `g_image` varchar(255) DEFAULT NULL,
  `g_time` datetime DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  PRIMARY KEY (`g_id`),
  KEY `sad` (`gid`),
  CONSTRAINT `gpaper_ibfk_1` FOREIGN KEY (`gid`) REFERENCES `guser` (`id`) ON DELETE CASCADE ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gpaper
-- ----------------------------
INSERT INTO `gpaper` VALUES ('1', '搞笑', '我的第一条', 'images/8.jpg', '2017-05-23 04:05:00', '1');
INSERT INTO `gpaper` VALUES ('2', '搞笑', '空间爱仕达', 'images/8.jpg', '2017-05-24 10:29:00', '1');
INSERT INTO `gpaper` VALUES ('3', '娱乐', '今天很开心！！！', 'images/9.jpg', '2017-05-24 10:53:00', '3');
INSERT INTO `gpaper` VALUES ('4', '娱乐', '撒旦噶速度更多', 'images/8.jpg', '2017-05-24 10:53:00', '1');

-- ----------------------------
-- Table structure for `guser`
-- ----------------------------
DROP TABLE IF EXISTS `guser`;
CREATE TABLE `guser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `upass` varchar(255) DEFAULT NULL,
  `guan_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of guser
-- ----------------------------
INSERT INTO `guser` VALUES ('1', 'zhangsan', '123456', 'images/banner-2.jpg');
INSERT INTO `guser` VALUES ('3', 'aaa', 'aaa', 'images/slide-2.jpg');
INSERT INTO `guser` VALUES ('4', '撒大声地', '15976', 'images/slide-3.jpg');

-- ----------------------------
-- Table structure for `paper`
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_type` varchar(255) DEFAULT NULL,
  `post_content` varchar(500) DEFAULT NULL,
  `post_image` varchar(255) DEFAULT NULL,
  `post_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`post_id`),
  KEY `a` (`user_id`),
  CONSTRAINT `paper_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('1', '搞笑', '\"被语文老师在课堂上污蔑的时候。我上学的时候一直都是优等生，从小的到大都很受老师欢迎的孩子，但那也挡不住有些老师就是莫名地不喜欢你。我当然没指望大家都喜欢我，但我真的很恶心利用职权就随意污蔑人的人，哪怕对方是老师\"', 'images/5.jpg', '2017-05-16 17:46:38', '1');
INSERT INTO `paper` VALUES ('2', '校园', 'c；课堂', 'images/22.jpg', '2017-05-16 17:58:03', '2');
INSERT INTO `paper` VALUES ('3', '搞笑', '假如你超级超级喜欢的人不小心掉进粪坑，捞上来需要做人工呼吸，你会怎么办？', 'images/9.jpg', '2017-05-19 10:18:00', '2');
INSERT INTO `paper` VALUES ('5', '游戏', '爱上的王者荣耀【；】\r\n', 'images/67669852.jpg', '2017-05-19 02:34:00', '1');
INSERT INTO `paper` VALUES ('6', '搞笑', '小米：“你年薪多少？”小明：“800万”小米：“那一个月有80万哦！”小明：“是的，这是基本工资。” 小米：“不错嘛，做什么的？” 小明：“做梦的......”', 'images/10.jpg', '2017-05-23 09:32:42', '1');
INSERT INTO `paper` VALUES ('7', '搞笑', '1号：哪怕我面前站着十个美女，只要你一出现，她们就会黯淡无光！   2号：讨厌，我有那么光彩照人么？   1号：没，是你太胖了，挡住光了！', 'images/9.jpg', '2017-05-11 09:58:01', '2');
INSERT INTO `paper` VALUES ('8', '校园', '这种人怎么配做老师（侵删）   例如：初一的时候班主任语文老师   是个女的，超级变态       抓住几个男生抽烟，逼男生把烟吃下去   几个男生在办公室吐的昏天黑地。', 'images/1.jpg', '2017-05-23 09:58:05', '2');
INSERT INTO `paper` VALUES ('9', '校园', '时光静走，清葱岁月，弹指间，昨夕稚气懵懂的样子也被时光淘洗的恍若两世。有人说，学校是梦想者的天堂，是无梦者的温床。也许，众生都有自己的生活轨迹与法则。成功与否，也都收拾行李，也收拾心情。', 'images/5.jpg', '2017-05-19 10:07:34', '1');
INSERT INTO `paper` VALUES ('10', '校园', '掰手指算算，一个人总有16年左右的时间和学校扯不开关系，或者有人会更多...那么那么久的上学时光，总有些好的坏的回忆，说说上学那点事儿！', 'images/2.jpg', '2017-05-23 10:17:56', '2');
INSERT INTO `paper` VALUES ('11', '游戏', '粉丝们你们想带我掉分可以直接说，不要这样只来坑我猴子的胜率好吗？今天的第一把五排就是被你们这样只选英雄弄输的，别吓得我以后都有点不敢带粉了！', 'images/7.jpg', '2017-05-23 10:24:05', '1');
INSERT INTO `paper` VALUES ('12', '游戏', '早死早超生，希望在来生。我心地好，送你一程！----刘邦（君主）      记得以前被个皇帝迷得神魂颠倒~~~（评论里有补图）', 'images/3.jpg', '2017-05-23 10:31:03', '2');
INSERT INTO `paper` VALUES ('13', '游戏', '有一个比你会玩王者的长辈或者后辈是什么感觉, 哈哈哈~~~', 'images/11.jpg', '2017-05-25 10:40:43', '1');
INSERT INTO `paper` VALUES ('14', '搞笑', '脑残人人有，今年特别多，说说看生活中见到的脑残行为有那些？     冷漠黑衣男表示     我的内心毫无波澜，甚至有点想笑。', 'images/9.jpg', '2017-05-05 10:57:52', '2');
INSERT INTO `paper` VALUES ('15', '老司机', '今天桃花运来了，我梦寐以求的女神突然找我，女神突然塞个橙子给我，然后对我说：今晚等我下班。我没想那么多然后就把橙子吃了，到了下班，女神问我：橙子呢？我说：吃掉了。女神就生气走了，是怎么回事？', 'images/9.jpg', '2017-05-19 11:05:16', '1');
INSERT INTO `paper` VALUES ('16', '老司机', '龙卷风；联合建立；反应慢了；额', 'images/b.jpg', '2017-05-23 03:16:00', '1');
INSERT INTO `paper` VALUES ('17', '搞笑', '我曾被3个人围过，只因为你我长得瘦看起来好欺负，但最后他们一人给了我20块钱走了！！！', 'images/3.jpg', '2017-05-23 05:34:00', '1');
INSERT INTO `paper` VALUES ('19', '游戏', '崔博士', 'images/24.jpg', '2017-05-26 08:44:00', '1');

-- ----------------------------
-- Table structure for `shoucang`
-- ----------------------------
DROP TABLE IF EXISTS `shoucang`;
CREATE TABLE `shoucang` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  KEY `被收藏帖子的id` (`post_id`),
  KEY `收藏人的id` (`user_id`),
  CONSTRAINT `shoucang_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `paper` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shoucang_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoucang
-- ----------------------------
INSERT INTO `shoucang` VALUES ('1', '3', '1');
INSERT INTO `shoucang` VALUES ('2', '2', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `upass` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `head_portrait` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '521521', '35fd19fbe470f0cb5581884fa700610f', '男', 'images/a.jpg');
INSERT INTO `user` VALUES ('2', '12345', '827ccb0eea8a706c4c34a16891f84e7b', '女', 'images/b.jpg');
INSERT INTO `user` VALUES ('3', '520520', '1104959d53dc3b60f2d40cd4a47d79e7', '女', 'images/2.jpg');
INSERT INTO `user` VALUES ('4', '123456', 'e10adc3949ba59abbe56e057f20f883e', '男', 'images/2.jpg');
