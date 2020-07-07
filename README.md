# myWebChat

 
	 1，数据库搭建：
	 
	 
	表1(User)：
	INSERT INTO `mywebchat`.`User` (`id`, `username`, `password`, `chatname`) 
	VALUES ('1', 'Haibaraai', '4869', 'Sherry');
    INSERT INTO `mywebchat`.`User` (`id`, `username`, `password`, `chatname`) 
	VALUES ('2', 'Cristina', '0000', 'Cris');
    
	表2(ChatRecord)
	INSERT INTO `mywebchat`.`ChatRecord` (`username1`, `username2`, `chatRecord`)
	VALUES ('Haibaraai', 'Cristina', NULL);
  
             1，一对多，多对多查询？？？，为啥jdbcTemplate无法封装非自定义对象集合？？
  
  
  2，servlet编写
             1，当对用户进行同一类操作（CRUD）时，可以通过创建BeanServlet的方式来减少相似操作的Servlet创建，只需要在servlet中定义方法调用即可。
  
  3，html页面编写
     
     
     
     遇到的问题：
              1，如果请求后台回传的结果是对象或是集合等复杂数据，可以使用JSONArray工具类（需要倒包）来把对象转换称json格式，然后在前台用 JSON.parse(result);转换成json对象即可使用。
              2，标签体的属性内容能否用用字符串拼接，例如 lis+="<div id='1_div' onclick... 这里的id属性下划线前的数字能否通过字符串实现动态创建标签。
              3，
