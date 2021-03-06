<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- mian header -->
<c:import url="/WEB-INF/layout/common/main/artHeader.jsp"></c:import> 

<!-- artistpage header -->    
<c:import url="/WEB-INF/layout/artist/artistpageheader.jsp"></c:import> 
<script type="text/javascript">
function classDelete(classno){
	
	var res = confirm("클래스를 정말 삭제하시겠습니까?");
	
	if(res){
		location.href = "/artist/class/delete?classno=" + classno;
	}
}
</script>


<style type="text/css">
#SvnClassManage{
	color: #e7717d;
}

#classTable{
	font-size: 14px;
}

#classTable th{
	text-align: center;
}
#classTable tr:first-child{
	background: thistle;
}

#classTable tr td{
	vertical-align: middle;
}

#classImg{
	width: 100px;
	height: 100px;
}

</style>

<div id="main">
	<span id="boardtitle">클래스 관리</span>
	<hr>
	<br>
	
	<table id="classTable" class="table table-condensed text-center table-hover">
	<tr>
		<th>번호</th>
		<th>사진</th>
		<th>클래스명</th>
		<th>카테고리</th>
		<th>지역</th>
		<th>게시 날짜</th>
		<th>상세보기</th>
	</tr>
	<c:if test="${empty list }">
		<tr>
			<th colspan="7" style="color: thistle; font-weight: bold;">등록된 클래스가 없습니다</th>
		</tr>
	</c:if>
	
	<c:forEach var="info" items="${list }" varStatus="status">
	<tr class="table-hover">
		<td>${status.count }</td>
		<td><img id="classImg" src="/upload/${info.classRenameFilename }" class="img-rounded imgsize" alt="image"/></td>
		<td>${info.className }</td>
		<td>
		<c:if test="${info.category eq 1}">플라워</c:if>
		<c:if test="${info.category eq 2}">음악</c:if>
		<c:if test="${info.category eq 3}">수공예</c:if>
		<c:if test="${info.category eq 4}">요리</c:if>
		<c:if test="${info.category eq 5}">뷰티</c:if>
		<c:if test="${info.category eq 6}">미술</c:if>
		<c:if test="${info.category eq 7}">기타</c:if>
		</td>
		<td>
		<c:if test="${info.location eq 1}">서울</c:if>
		<c:if test="${info.location eq 2}">경기</c:if>
		<c:if test="${info.location eq 3}">강원</c:if>
		<c:if test="${info.location eq 4}">충청</c:if>
		<c:if test="${info.location eq 5}">경상</c:if>
		<c:if test="${info.location eq 6}">전라</c:if>
		<c:if test="${info.location eq 7}">제주</c:if>
		</td>
		<td>${info.postDate }</td>
		<td>
		<button type="button" onclick="location.href='/artist/class/update?classno=${info.classNo }'">수정</button>
		<button type="button" onclick="classDelete(${info.classNo})">삭제</button>
		</td>
	</tr>
	</c:forEach>

</table>

<c:if test="${not empty list }">
	<c:import url="/WEB-INF/paging/artistClassManage.jsp" />
</c:if>	

<div class="clearfix"></div>
</div> <!-- 전체를 감싸는 div -->
</section>


<c:import url="/WEB-INF/layout/common/main/footer.jsp"></c:import>