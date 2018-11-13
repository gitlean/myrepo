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
//                    show: false //����ʾ��ʾ��ǩ
                    formatter: '{b}', //��ʾ��ǩ��ʽ
                    backgroundColor:"#ff7f50",//��ʾ��ǩ������ɫ
                    textStyle:{color:"#fff"} //��ʾ��ǩ������ɫ
                },
                
                
    			//���С����ͼ��
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
                            show: true,//��ʾʡ�ݱ�ǩ
                            textStyle:{color:"#c71585"}//ʡ�ݱ�ǩ������ɫ
                        },    
                        emphasis: {//��Ӧ���������Ч��
                            show: true,
                            textStyle:{color:"#800080"}
                        } 
                    },
                    itemStyle: {
                        normal: {
                            borderWidth: .5,//����߿���
                            borderColor: '#009fe8',//����߿���ɫ
                            areaColor:"#ffefd5",//������ɫ
                        },
                        emphasis: {
                            borderWidth: .5,
                            borderColor: '#4b0082',
                            areaColor:"#ffdead",
                        }
                    },
                    data:[
                        {name:'����', selected:true}//����Ϊѡ��״̬
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