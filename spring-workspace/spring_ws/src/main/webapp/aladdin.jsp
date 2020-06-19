<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
	<!-- 차트js -->
<script src="/resources/js/Chart.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.js"></script>

<script src="http://code.jquery.com/jquery-latest.js"></script>
    <!-- google charts -->
	   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
	$(function() {

		$("#btn1").click(function() {
			var title = $("#title").val();
			$.ajax({
				url : "/aladdin.do",
				type : "get",
				data : {
					title : title
				},
				success : function(data) {
					html = "";
					console.log(data);
					for (var i = 0; i < data.length; i++) {
						html += "<tr><td><img src='"+data[i].cover+"'></td>";
						html += "<td>" + data[i].title + "</td>";
						html += "<td>" + data[i].author + "</td>";
						html += "<td>" + data[i].pubDate + "</td>";
						html += "<td>" + data[i].publisher + "</td>";
						html += "<td>" + data[i].categoryId + "</td>";
						html += "<td>" + data[i].categoryName + "</td>";
						html += "<td>" + data[i].description + "</td>";
					}
					$("table>tbody").append(html);
				},
				error : function(data) {
					console.log("ajax 실패");
					console.log(data)
				}
			});
		});
	});
</script>
 <script>

  var chartDrowFun = {

    chartDrow : function(){
        var chartData = '';

        //날짜형식 변경하고 싶으시면 이 부분 수정하세요.
        var chartDateformat 	= 'yyyy년MM월dd일';
        //라인차트의 라인 수
        var chartLineCount    = 10;
        //컨트롤러 바 차트의 라인 수
        var controlLineCount	= 10;


        function drawDashboard() {

          var data = new google.visualization.DataTable();
          //그래프에 표시할 컬럼 추가
          data.addColumn('datetime' , '날짜');
          data.addColumn('number'   , '남성');
          data.addColumn('number'   , '여성');
          data.addColumn('number'   , '전체');

          //그래프에 표시할 데이터
          var dataRow = [];

          for(var i = 0; i <= 29; i++){ //랜덤 데이터 생성
            var total   = Math.floor(Math.random() * 300) + 1;
            var man     = Math.floor(Math.random() * total) + 1;
            var woman   = total - man;

            dataRow = [new Date('2017', '09', i , '10'), man, woman , total];
            data.addRow(dataRow);
          }


            var chart = new google.visualization.ChartWrapper({
              chartType   : 'LineChart',
              containerId : 'lineChartArea', //라인 차트 생성할 영역
              options     : {
                              isStacked   : 'percent',
                              focusTarget : 'category',
                              height		  : 500,
                              width			  : '100%',
                              legend		  : { position: "top", textStyle: {fontSize: 13}},
                              pointSize		: 5,
                              tooltip		  : {textStyle : {fontSize:12}, showColorCode : true,trigger: 'both'},
                              hAxis			  : {format: chartDateformat, gridlines:{count:chartLineCount,units: {
                                                                  years : {format: ['yyyy년']},
                                                                  months: {format: ['MM월']},
                                                                  days  : {format: ['dd일']},
                                                                  hours : {format: ['HH시']}}
                                                                },textStyle: {fontSize:12}},
                vAxis			  : {minValue: 100,viewWindow:{min:0},gridlines:{count:-1},textStyle:{fontSize:12}},
                animation		: {startup: true,duration: 1000,easing: 'in' },
                annotations	: {pattern: chartDateformat,
                                textStyle: {
                                fontSize: 15,
                                bold: true,
                                italic: true,
                                color: '#871b47',
                                auraColor: '#d799ae',
                                opacity: 0.8,
                                pattern: chartDateformat
                              }
                            }
              }
            });

            var control = new google.visualization.ControlWrapper({
              controlType: 'ChartRangeFilter',
              containerId: 'controlsArea',  //control bar를 생성할 영역
              options: {
                  ui:{
                        chartType: 'LineChart',
                        chartOptions: {
                        chartArea: {'width': '60%','height' : 80},
                          hAxis: {'baselineColor': 'none', format: chartDateformat, textStyle: {fontSize:12},
                            gridlines:{count:controlLineCount,units: {
                                  years : {format: ['yyyy년']},
                                  months: {format: ['MM월']},
                                  days  : {format: ['dd일']},
                                  hours : {format: ['HH시']}}
                            }}
                        }
                  },
                    filterColumnIndex: 0
                }
            });

            var date_formatter = new google.visualization.DateFormat({ pattern: chartDateformat});
            date_formatter.format(data, 0);

            var dashboard = new google.visualization.Dashboard(document.getElementById('Line_Controls_Chart'));
            window.addEventListener('resize', function() { dashboard.draw(data); }, false); //화면 크기에 따라 그래프 크기 변경
            dashboard.bind([control], [chart]);
            dashboard.draw(data);

        }
          google.charts.setOnLoadCallback(drawDashboard);

      }
    }

$(document).ready(function(){
  google.charts.load('current', {'packages':['line','controls']});
	/* 파이차트 로딩 */
  google.charts.load('current', {'packages':['corechart']});

  chartDrowFun.chartDrow(); //chartDrow() 실행
});
  </script>
  <!-- 구글차트 파이 차트. -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['GENRE', 'one Genre in ReadingBooks'],
          ['로맨스',     20],
          ['소설/희곡/시',      10],
          ['참고서',  4],
          ['경제경영', 9],
          ['잡지',    13]
        ]);

        var options = {
          title: '읽은 책들의 장르 비율',
          sliceVisibilityThreshold: .1
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
<body>
	<hr>
	표 테스트
    <h4>사이트 방문자 성별 현황 그래프</h4>

    <div id="Line_Controls_Chart">
      <!-- 라인 차트 생성할 영역 -->
  		<div id="lineChartArea" style="padding:0px 20px 0px 0px;"></div>
      <!-- 컨트롤바를 생성할 영역 -->
  		<div id="controlsArea" style="padding:0px 20px 0px 0px;"></div>
		</div>
	<hr>
	<H4>구글차트 테스트</H4>
	    <div id="piechart" style="width: 900px; height: 500px;"></div>
	<HR>
	<br> 책이름 :
	<input type="text" name="title" id="title">
	<button type="button" id="btn1">검색</button>
	<!-- 		<a href="/베스트셀러.xlsx">다운로드</a> -->
	<hr>
	<table border="1">
		<tr>
			<th>cover</th>
			<th>title</th>
			<th>author</th>
			<th>pubDate</th>
			<th>publisher</th>
			<th>categoryId</th>
			<th>categoryName</th>
			<th>description</th>
		</tr>
	</table>
</body>
</html>