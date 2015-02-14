<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript" src="js/highcharts.js"></script>

<script type="text/javascript">
	//ws＝websocket的一个变量
	var ws = null;
	//startServer()函数在body标签加载的时候调用
	function startServer() {
		//服务该页面的URL，类似于服务Get和服务Post的URL
		var url = "ws://localhost:8080/ws/echo2.ws"
		if ('WebSocket' in window) {
			//根据不同的浏览器内核调用浏览器支持创建websocket的方法
			ws = new WebSocket(url)
		} else if ('MozWebSocket' in window) {
			//根据不同的浏览器内核调用浏览器支持创建websocket的方法
			ws = new MozWebSocket(url)
		} else {
			//浏览器不支持WebSocket
			alert('UnSupported WebSocket')
			return;
		}

		ws.onopen = function() {
		}
		k = [];
		count = 0

		ws.onmessage = function(event) {
			k.push(eval("(" + event.data + ")"))
			if (count === k.length) {

			} else {
				count = k.length
				//回调函数，当websocket接收到服务器端发送来的信息时候
				$(function() {
					$('#container').highcharts({
						chart : {
							type : 'spline'
						},

						xAxis : {
							type : 'datetime'
						},
						yAxis : {
							title : {
								text : 'Wind speed (m/s)'
							},
							min : 0,
							minorGridLineWidth : 0,
							gridLineWidth : 0,
							alternateGridColor : null,
							plotBands : [ { // Light air
								from : 0.3,
								to : 1.5,
								color : 'rgba(68, 170, 213, 0.1)',
								label : {
									text : 'Light air',
									style : {
										color : '#606060'
									}
								}
							}, { // Light breeze
								from : 1.5,
								to : 3.3,
								color : 'rgba(0, 0, 0, 0)',
								label : {
									text : 'Light breeze',
									style : {
										color : '#606060'
									}
								}
							}, { // Gentle breeze
								from : 3.3,
								to : 5.5,
								color : 'rgba(68, 170, 213, 0.1)',
								label : {
									text : 'Gentle breeze',
									style : {
										color : '#606060'
									}
								}
							}, { // Moderate breeze
								from : 5.5,
								to : 8,
								color : 'rgba(0, 0, 0, 0)',
								label : {
									text : 'Moderate breeze',
									style : {
										color : '#606060'
									}
								}
							}, { // Fresh breeze
								from : 8,
								to : 11,
								color : 'rgba(68, 170, 213, 0.1)',
								label : {
									text : 'Fresh breeze',
									style : {
										color : '#606060'
									}
								}
							}, { // Strong breeze
								from : 11,
								to : 14,
								color : 'rgba(0, 0, 0, 0)',
								label : {
									text : 'Strong breeze',
									style : {
										color : '#606060'
									}
								}
							}, { // High wind
								from : 14,
								to : 15,
								color : 'rgba(68, 170, 213, 0.1)',
								label : {
									text : 'High wind',
									style : {
										color : '#606060'
									}
								}
							} ]
						},

						plotOptions : {
							spline : {
								lineWidth : 4,
								states : {
									hover : {
										lineWidth : 5
									}
								},
								marker : {
									enabled : false
								},
								pointInterval : 3600000, // one hour
								pointStart : Date.UTC(2009, 9, 6, 0, 0, 0)
							}
						},
						series : k,
						navigation : {
							menuItemStyle : {
								fontSize : '10px'
							}
						}
					});
				});
			}
		}

	}
</script>

</head>

<body onload="startServer()">
	<div id="container" style="min-width: 800px; height: 400px;"></div>
	<div id="content"></div>

	<script>
		var testData = [ -0.84933472, -0.80239868, -0.75091553, -0.71078491,
				-0.67428589, -0.64089966, -0.60394287, -0.56738281,
				-0.53601074, -0.51296997, -0.48864746, -0.4574585 ]
		setInterval("ws.send('" + testData + "')", 1000)
	</script>
</body>
</html>