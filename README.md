# ClassManagement
请留意阿里规约
12.16
1、js文件夹没建好，要建一下
2、【在界面或者在本地localhost上的登录页面是http://120.77.173.98:8201/login ，在HelloController里第一个方法就是，很容易看懂，你们可以自己跑跑试试。】
3、一部分的图片路径有问题，有些是img但写成了Img，有些是../../img但写成了../img，因此显示不出来，需要改
4、界面的整洁度需要我们自己修改，比如有些按钮挡住文字了，比如有些按钮背景没有了，只剩按钮上的字，还比如教师学生界面有选择学校，但目前我们的界面上没有写，应该是漏了，要补上，还有微信扫码登录的那个页面有问题
5、跳转的过程：界面的href=“classInfo”对应到HelloController里的@RequestMapping("/teacher/classInfo")，返回值是"teacher/TeacherClassInfo"，也就是对应跳转到TeacherClassInfo.html。controller里的跳转url都设置好了，现在需要改的是每一个html里的href，有些锚没有设置href的要加上，有些href是“/common/AccountLoginPage.html”这种路径，要改成controller里面url的路径，并且是没有后缀的。有些标签没有href属性的就利用js来设置跳转，例如window.lacation.href="classInfo"。注意是使用“/classInfo”还是“classInfo”，是目录的级别层次。
6、报错是500的是找不到html,是404的是href出的问题，看报错页面的 url来找问题
