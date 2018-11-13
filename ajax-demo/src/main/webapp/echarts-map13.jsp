<!DOCTYPE html>
<html>
    <head>
       
        <title>ECharts</title>
       
        <script src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
        <script src="<%=request.getContextPath()%>/js/echarts.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/china.js"></script>
        
		<style>
		#china-map {
			width: 1000px;
			height: 1000px;
			margin: auto;
		}
		</style>
</head>
    <body>        

        <div id="china-map"></div>
        
        <script>
            var myChart = echarts.init(document.getElementById('china-map'));
            var option = {
                tooltip: {
//                    show: false //不显示提示标签
                    formatter: '{b}', //提示标签格式
                    backgroundColor:"#ff7f50",//提示标签背景颜色
                    textStyle:{color:"#fff"} //提示标签字体颜色
                },
                
                
    			//左侧小导航图标
    			visualMap : {
    				show : true,
    				x : 'left',
    				y : 'center',
    				splitList : [ {
    					start : 500,
    					end : 600
    				}, {
    					start : 400,
    					end : 500
    				}, {
    					start : 300,
    					end : 400
    				}, {
    					start : 200,
    					end : 300
    				}, {
    					start : 100,
    					end : 200
    				}, {
    					start : 0,
    					end : 100
    				}, ],
    				color : [ '#5475f5', '#9feaa5', '#85daef', '#74e2ca',
    						'#e6ac53', '#9fb5ea' ]
    			},
                
                
                series: [{
                    type: 'map',
                    mapType: 'china',
                    label: {
                        normal: {
                            show: true,//显示省份标签
                            textStyle:{color:"#c71585"}//省份标签字体颜色
                        },    
                        emphasis: {//对应的鼠标悬浮效果
                            show: true,
                            textStyle:{color:"#800080"}
                        } 
                    },
                    itemStyle: {
                        normal: {
                            borderWidth: .5,//区域边框宽度
                            borderColor: '#009fe8',//区域边框颜色
                            areaColor:"#ffefd5",//区域颜色
                        },
                        emphasis: {
                            borderWidth: .5,
                            borderColor: '#4b0082',
                            areaColor:"#ffdead",
                        }
                    },
                    data:[
                        {name:'福建', selected:true}//福建为选中状态
                    ]
                }],
            };
            
            myChart.setOption(option);
            myChart.on('mouseover', function (params) {
                var dataIndex = params.dataIndex;
                console.log(params);
            });
        </script>
        
    </body>
</html>