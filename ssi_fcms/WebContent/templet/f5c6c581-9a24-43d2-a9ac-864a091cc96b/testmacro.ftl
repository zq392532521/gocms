<html><br> 
<head><br> 
<title>Welcome!</title><br> 
</head><br> 
<body><br> 
<#-- 注释部分 --><br> 
<#-- 下面使用插值 --> 
<h1>Welcome ${user} !</h1><br> 
<p>We have these animals:<br> 
<u1><br> 
<#-- 使用FTL指令 --> 
<#list animals as being><br> 
   <li>${being.name} for ${being.price} Euros<br> 
<#list><br> 
<u1><br> 
</body><br> 
</html> 
