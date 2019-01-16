
## Android学习过程中写的小例子

1. 2019.1.9 ActivityTest  
Activity之间的切换以及数据的传递  

2. 2019.1.10 ListViewTest  
ListView的简单用法  

3. 2019.1.14 RecyclerViewTest  
RecyclerView的简单用法  

4. 2019.1.14 UICustomViews  
创建自定义控件-简单标题栏  

5. 2019.1.15 UIBestPractice  
一个简单的AI聊天实现  
  
6. 2019.1.16 BroadcastTest  
接收系统广播、静态注册广播  
发送自定义广播  
- 书中使用此例子进行自定义广播的发送，但发送后接收器无反应。  
- 经查证后，Android 8.0 对广播增加了限制，除了有限的例外广播，应用不能使用清单（AndroidManifest.xml)注册隐式广播。但可以在运行时动态注册这些广播，并且可以使用清单注册专门针对他们的显示广播。（API 26）

