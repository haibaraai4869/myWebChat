# myWebChat

 
	 1，数据库搭建：
	 
	 
	表1(User)：有id,username,password,chatname四个字段，用于存储用户信息数据
	
	表2(userRelation)：有username1，username2，requestConform三个字段，用于存储用户关系数据
	
        表3(user_imag):有username和picPath两个字段，用于存储用户头像数据
	
        表4(correspInfo):有senduser，acceptuser，chatTime和chatRecord四个字段，用于存储用户聊天记录数据
	
           
  
  
 	 2，servlet编写
             当需要创建的Servlet是同一模块的需求时，可以通过创建BeanServlet的方式来减少相似操作的Servlet创建，只需要在servlet中定义方法调用即可。
	     servlet具体分为四大块，分别为
	     
	     LoginServlet：用于管理用户注册和登录
	     
	     UserServlet：用于管理用户自身信息
	    
	     FriendServlet：用于管理好友
	    
	     CorrespondServlet：用于管理用户间的请求消息，通信消息
	     
	     
  
 	 3，html页面编写
            Login.html：登陆页面
	    
	    Register.html：注册页面
	    
	    Index.html：好友列表页面
	    
	    AddFriend.html:添加好友页面
	    
	    PersonCenter:个人中心页面
	    
	    PersonInfo：个人信息修改页面
	    
	    SelectPic.html：头像修改页面
	    
	    ChatWindow.html:聊天框页面
	    
	  4，实现功能逻辑
	     
	     登录/注册：简单的提交表单查询/插入数据到user表中
	     
	     好友列表展示：ajax请求后台查询数据库封装为集合json数据返回前台调用
		     然后前台通过遍历循环动态创建标签（其实就是拼字符串）然后通过jquery的.html()方法写如body中，很容易出错，而且很难动态的添加属性，
		     我的解决方法是在创建的动态标签中的子标签的onclick=function（this），把子标签自身作为参数，然后通过这个对象的父标签的text（用户名不同可作为区分的依据）
		     来调用所需标签，给其添加单击事件在其中再次拼接字符串添加两个按钮（删除好友和发送消息）
		     
	     好友的删除/个人信息修改：同样是简单的提交表单或用户名发给后台修改数据库而已
	     
	     聊天功能：sender发给accepter，并把聊天时间和内容记下来一同写到数据库中，accepter直接根据数据库中内容展示即可，但需要15秒查询一次
	     
	     添加好友：通过username查询没什么好说的，通过昵称模糊查询需要拼一下字符串String like_charName="%"+chatName+"%";
             String sql="select * from user where chatName like ?";查询出来的数据跟好友列表展示原理一样，拼字符串写进body就完事了
	     
	     好友请求：发送请求时先插入单向关系数据，待接收者同意后再修改确认字段并创建双向数据
	     
	     头像展示/修改：在展示列表动态创建标签时拼接iamg标签作为子标签一同写入即可，修改可以通过用户名直接修改图片路径即可
	     
	     
	     
	     
