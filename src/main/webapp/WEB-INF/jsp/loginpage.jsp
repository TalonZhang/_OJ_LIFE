<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>OJ江湖</title>
        <base href=" <%=basePath%>">
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/bootstrapVaildator/bootstrapValidator.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

        <!-- Content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                        	<!--<a class="logo" href="index.html"></a>-->
                            <h1><strong>O J 江 湖</strong> </h1>
                            <div class="description">
                            	<p>
	                            	这里是oj江湖，没错这里是oj江湖，是的这里就是oj江湖。
	                            	不用看了这里就是oj江湖，不骗你这里真的是 <a href="#"><strong>oj江湖</strong></a>,好吧你要实在不信我也没办法，但这里确实就是oj江湖!
                            	</p>
                            </div>
                            <div class="top-big-link">
                            	<a class="btn btn-link-1 launch-modal" href="#" data-modal-id="modal-login">登录</a>
								<a class="btn btn-link-1 launch-modal" href="#" data-modal-id="modal-register">注册</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        
        <!-- MODAL LOGIN -->
        <div class="modal fade" id="modal-login" tabindex="-1" role="dialog" aria-labelledby="modal-login-label" aria-hidden="true">
        	<div class="modal-dialog">
        		<div class="modal-content" style="margin-top: 30%">
        			
        			<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal">
        					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        				</button>
        				<h3 class="modal-title" id="modal-login-label">登录</h3>
        				<p>请输入用户名和密码：</p>
        			</div>
        			
        			<div class="modal-body">
        				
	                    <form role="form" action="" method="post" class="login-form" id="login-form">
	                    	<div class="form-group">
	                    		<label class="sr-only" for="form-login-email">email</label>
	                        	<input type="text" name="email" placeholder="邮箱..." class="form-email form-control" id="form-login-email">
	                        </div>
                            <div class="form-group form-hidden" id="form-hidden-login-email">
                                <p>邮箱不能为空!</p>
                            </div>
	                        <div class="form-group">
	                        	<label class="sr-only" for="form-login-password">password</label>
	                        	<input type="password" name="password" placeholder="密码..." class="form-username form-control" id="form-login-password">
	                        </div>
                            <div class="form-group form-hidden" id="form-hidden-login-password">
                                <p>密码不能为空!</p>
                            </div>
	                        <button type="submit" class="btn" id="login" onclick="return false">登录</button>
	                    </form>
	                    
        			</div>
        			
        		</div>
        	</div>
        </div>

		<!-- MODAL REGISTER -->
		<div class="modal fade" id="modal-register" tabindex="-1" role="dialog" aria-labelledby="modal-register-label" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" style="margin-top: 25%">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h3 class="modal-title" id="modal-register-label">注册</h3>
						<p>请填写以下信息：</p>
					</div>

					<div class="modal-body">

						<form role="form" action="#" method="post" class="registration-form" id="register-form">
							<div class="form-group">
								<label class="sr-only" for="form-register-email">email</label>
								<input type="email" name="email" placeholder="邮箱..." class="form-register-email form-control" id="form-register-email">
							</div>
                            <div class="form-group form-hidden" id="form-hidden-email">
                                <p>该邮箱已被注册!</p>
                            </div>
							<div class="form-group">
								<label class="sr-only" for="form-register-nickname">nickname</label>
								<input type="text" name="nickname" placeholder="昵称..." class="form-register-nickname form-control" id="form-register-nickname">
							</div>
                            <div class="form-group form-hidden" id="form-hidden-nickname">
                                <p>该昵称已被注册!</p>
                            </div>
							<div class="form-group">
								<label class="sr-only" for="form-register-password">password</label>
								<input type="password" name="password" placeholder="密码..." class="form-register-password password-judge form-control" id="form-register-password">
							</div>
                            <div class="form-group form-hidden" id="form-hidden-password">
                                <p>密码不能低于6位!</p>
                            </div>
							<div class="form-group">
								<label class="sr-only" for="form-register-confirm">confirm</label>
								<input type="password" name="confirmPassword" placeholder="再次输入密码..." class="form-register-confirm password-judge form-control" id="form-register-confirm">
							</div>
                            <div class="form-group form-hidden" id="form-hidden-confirm">
                                <p>两次输入密码不一致!</p>
                            </div>
							<button type="submit" class="btn" id="register" onclick="return false;" disabled="ture">注册</button>
						</form>


					</div>

				</div>
			</div>
		</div>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        <!--<script src="assets/js/judge.js"></script>-->
        <script src="assets/bootstrapVaildator/bootstrapValidator.min.js"></script>
        <script src="assets/bootstrapVaildator/language/zh_CN.js"></script>
        <script type="text/javascript">

            $(document).ready(function() {

                $('#register-form').bootstrapValidator({
                    message:"该值无效",
                    fields: {
                        nickname: {
                            message: '昵称无效',
                            validators: {
                                notEmpty: {
                                    message: '昵称不能为空'
                                },
                                stringLength: {
                                    min: 3,
                                    message: "昵称长度不能低于3位"
                                },
                                remote: {
                                    url: '/user/checknickname',
                                    message: '该昵称已被注册'
                                },
                                different: {
                                    field: 'password',
                                    message: '昵称不能与密码相同'
                                },
                                regexp: {
                                    regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                                    message: '昵称只能由字母、数字、点、下划线和汉字组成 '
                                }
                            }
                        },
                        email: {
                            validators: {
                                emailAddress: {

                                },
                                remote: {
                                    url: '/user/checkemail',
                                    message: '该邮箱已被注册'
                                },
                            }
                        },
                        password: {
                            validators: {
                                notEmpty: {
                                    message:"密码不能为空"
                                },
                                stringLength: {
                                    min: 6,
                                    message: "密码长度最少为6位"
                                },
                                regexp: {
                                    regexp: /^[a-zA-Z0-9_\.]+$/,
                                    message: '密码只能包含数字，点和下划线'
                                },
                                identical: {
                                    field: 'confirmPassword',
                                    message:"两次密码输入不一致"
                                },
                                different: {
                                    field: 'nickname',
                                    message:"密码不能与昵称相同"
                                }
                            }
                        },
                        confirmPassword: {
                            validators: {
                                notEmpty: {
                                    message:"密码不能为空"
                                },
                                stringLength: {
                                    min: 6,
                                    message: "密码长度最少为6位"
                                },
                                regexp: {
                                    regexp: /^[a-zA-Z0-9_\.]+$/,
                                    message: '密码只能包含数字，点和下划线'
                                },
                                identical: {
                                    field: 'password',
                                    message:"两次密码输入不一致"
                                },
                                different: {
                                    field: 'nickname',
                                    message:"密码不能与昵称相同"
                                }
                            }
                        }
                    }
                });

                $("#login-form").bootstrapValidator({
                    message:"该值无效",
                    fields: {
                        email: {
                            validators: {
                                emailAddress: {

                                }
                            }
                        },
                        password: {
                            validators: {
                                notEmpty: {
                                    message:"密码不能为空"
                                },
                                stringLength: {
                                    min: 6,
                                    message: "密码长度最少为6位"
                                },
                                regexp: {
                                    regexp: /^[a-zA-Z0-9_\.]+$/,
                                    message: '密码只能包含数字，点和下划线'
                                }
                            }
                        }
                    }
                });

                $("#register").click(function () {
                    var form=$('#register-form');
                    var bv =  form.data('bootstrapValidator');
                    bv.validate();
                    if (bv.isValid()) {
                        $.ajax({
                            url: '/user/register',
                            async: false,
                            type: 'POST',
                            data: form.serialize(),
                            success: function (data) {
                                if (data.ok) {
                                    alert("注册成功");
                                    location.href = "/";
                                } else {
                                    alert(data.msg);
                                }
                            }
                        })
                    }
                });

                $("#login").click(function () {
                    var form=$('#login-form');
                    var bv =  form.data('bootstrapValidator');
                    bv.validate();
                    if (bv.isValid()) {
                        $.ajax({
                            url: '/user/login',
                            async: false,
                            type: 'POST',
                            data: form.serialize(),
                            success: function (data) {
                                if (data.ok) {
                                    alert("登录成功");
                                    location.href = "/";
                                } else {
                                    alert(data.msg);
                                }
                            }
                        })
                    }
                });

            });
        </script>

        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>