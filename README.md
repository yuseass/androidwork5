# androidwork5
大三下android实验5

（1）掌握Tween动画基本编程技术；
（2）掌握Frame动画编程技术；
（3）掌握动画监听技术；


（1）	利用Tween动画实现小人移动到触摸位置(默认位置在左上角)；
（2）	利用Frame动画实现小人移动过程中的眨眼/咧嘴动作。
（3）	长按小人图像，先缩小，再放大，然后消失。
 
              


1.	创建ImageView用于显示动画。在drawable中写好frame动画的xml文件，并放上循环的图片
2.	给布局添加触摸监听事件，获得每次点下的位置
3.	创建translateAnimation,设定移动位置为当前坐标和触摸按下坐标，给ImageView启动动画
4.	监听上一个translateAnimation，按下时启动frame动画，停止时结束frame动画
5.	给ImageView添加长按监听，设置2个ScaleAnimation和一个AlphaAnimation，实现长按先缩小后放大，最后消失
