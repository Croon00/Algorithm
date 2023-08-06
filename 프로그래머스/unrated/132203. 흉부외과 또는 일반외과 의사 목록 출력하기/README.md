# [unrated] 흉부외과 또는 일반외과 의사 목록 출력하기 - 132203 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/132203) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > SELECT

### 채점결과

Empty

### 문제 설명

<p style="user-select: auto;">다음은 종합병원에 속한 의사 정보를 담은<code style="user-select: auto;">DOCTOR</code> 테이블입니다. <code style="user-select: auto;">DOCTOR</code> 테이블은 다음과 같으며 <code style="user-select: auto;">DR_NAME</code>, <code style="user-select: auto;">DR_ID</code>, <code style="user-select: auto;">LCNS_NO</code>, <code style="user-select: auto;">HIRE_YMD</code>, <code style="user-select: auto;">MCDP_CD</code>, <code style="user-select: auto;">TLNO</code>는 각각 의사이름, 의사ID, 면허번호, 고용일자, 진료과코드, 전화번호를 나타냅니다.</p>
<table class="table" style="user-select: auto;">
        <thead style="user-select: auto;"><tr style="user-select: auto;">
<th style="user-select: auto;">Column name</th>
<th style="user-select: auto;">Type</th>
<th style="user-select: auto;">Nullable</th>
</tr>
</thead>
        <tbody style="user-select: auto;"><tr style="user-select: auto;">
<td style="user-select: auto;">DR_NAME</td>
<td style="user-select: auto;">VARCHAR(20)</td>
<td style="user-select: auto;">FALSE</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">DR_ID</td>
<td style="user-select: auto;">VARCHAR(10)</td>
<td style="user-select: auto;">FALSE</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">LCNS_NO</td>
<td style="user-select: auto;">VARCHAR(30)</td>
<td style="user-select: auto;">FALSE</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">HIRE_YMD</td>
<td style="user-select: auto;">DATE</td>
<td style="user-select: auto;">FALSE</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">MCDP_CD</td>
<td style="user-select: auto;">VARCHAR(6)</td>
<td style="user-select: auto;">TRUE</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">TLNO</td>
<td style="user-select: auto;">VARCHAR(50)</td>
<td style="user-select: auto;">TRUE</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto;">

<h5 style="user-select: auto;">문제</h5>

<p style="user-select: auto;"><code style="user-select: auto;">DOCTOR</code> 테이블에서 진료과가 흉부외과(CS)이거나 일반외과(GS)인 의사의 이름, 의사ID, 진료과, 고용일자를 조회하는 SQL문을 작성해주세요. 이때 결과는 고용일자를 기준으로 내림차순 정렬하고, 고용일자가 같다면 이름을 기준으로 오름차순 정렬해주세요.</p>

<hr style="user-select: auto;">

<h5 style="user-select: auto;">예시</h5>

<p style="user-select: auto;"><code style="user-select: auto;">DOCTOR</code> 테이블이 다음과 같을 때</p>
<table class="table" style="user-select: auto;">
        <thead style="user-select: auto;"><tr style="user-select: auto;">
<th style="user-select: auto;">DR_NAME</th>
<th style="user-select: auto;">DR_ID</th>
<th style="user-select: auto;">LCNS_NO</th>
<th style="user-select: auto;">HIRE_YMD</th>
<th style="user-select: auto;">MCDP_CD</th>
<th style="user-select: auto;">TLNO</th>
</tr>
</thead>
        <tbody style="user-select: auto;"><tr style="user-select: auto;">
<td style="user-select: auto;">루피</td>
<td style="user-select: auto;">DR20090029</td>
<td style="user-select: auto;">LC00010001</td>
<td style="user-select: auto;">2009-03-01</td>
<td style="user-select: auto;">CS</td>
<td style="user-select: auto;">01085482011</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">패티</td>
<td style="user-select: auto;">DR20090001</td>
<td style="user-select: auto;">LC00010901</td>
<td style="user-select: auto;">2009-07-01</td>
<td style="user-select: auto;">CS</td>
<td style="user-select: auto;">01085220122</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">뽀로로</td>
<td style="user-select: auto;">DR20170123</td>
<td style="user-select: auto;">LC00091201</td>
<td style="user-select: auto;">2017-03-01</td>
<td style="user-select: auto;">GS</td>
<td style="user-select: auto;">01034969210</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">티거</td>
<td style="user-select: auto;">DR20100011</td>
<td style="user-select: auto;">LC00011201</td>
<td style="user-select: auto;">2010-03-01</td>
<td style="user-select: auto;">NP</td>
<td style="user-select: auto;">01034229818</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">품바</td>
<td style="user-select: auto;">DR20090231</td>
<td style="user-select: auto;">LC00011302</td>
<td style="user-select: auto;">2015-11-01</td>
<td style="user-select: auto;">OS</td>
<td style="user-select: auto;">01049840278</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">티몬</td>
<td style="user-select: auto;">DR20090112</td>
<td style="user-select: auto;">LC00011162</td>
<td style="user-select: auto;">2010-03-01</td>
<td style="user-select: auto;">FM</td>
<td style="user-select: auto;">01094622190</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">니모</td>
<td style="user-select: auto;">DR20200012</td>
<td style="user-select: auto;">LC00911162</td>
<td style="user-select: auto;">2020-03-01</td>
<td style="user-select: auto;">CS</td>
<td style="user-select: auto;">01089483921</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">오로라</td>
<td style="user-select: auto;">DR20100031</td>
<td style="user-select: auto;">LC00010327</td>
<td style="user-select: auto;">2010-11-01</td>
<td style="user-select: auto;">OS</td>
<td style="user-select: auto;">01098428957</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">자스민</td>
<td style="user-select: auto;">DR20100032</td>
<td style="user-select: auto;">LC00010192</td>
<td style="user-select: auto;">2010-03-01</td>
<td style="user-select: auto;">GS</td>
<td style="user-select: auto;">01023981922</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">벨</td>
<td style="user-select: auto;">DR20100039</td>
<td style="user-select: auto;">LC00010562</td>
<td style="user-select: auto;">2010-07-01</td>
<td style="user-select: auto;">GS</td>
<td style="user-select: auto;">01058390758</td>
</tr>
</tbody>
      </table>
<p style="user-select: auto;">SQL을 실행하면 다음과 같이 출력되어야 합니다.</p>
<table class="table" style="user-select: auto;">
        <thead style="user-select: auto;"><tr style="user-select: auto;">
<th style="user-select: auto;">DR_NAME</th>
<th style="user-select: auto;">DR_ID</th>
<th style="user-select: auto;">MCDP_CD</th>
<th style="user-select: auto;">HIRE_YMD</th>
</tr>
</thead>
        <tbody style="user-select: auto;"><tr style="user-select: auto;">
<td style="user-select: auto;">니모</td>
<td style="user-select: auto;">DR20200012</td>
<td style="user-select: auto;">CS</td>
<td style="user-select: auto;">2020-03-01</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">뽀로로</td>
<td style="user-select: auto;">DR20170123</td>
<td style="user-select: auto;">GS</td>
<td style="user-select: auto;">2017-03-01</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">벨</td>
<td style="user-select: auto;">DR20100039</td>
<td style="user-select: auto;">GS</td>
<td style="user-select: auto;">2010-07-01</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">자스민</td>
<td style="user-select: auto;">DR20100032</td>
<td style="user-select: auto;">GS</td>
<td style="user-select: auto;">2010-03-01</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">패티</td>
<td style="user-select: auto;">DR20090001</td>
<td style="user-select: auto;">CS</td>
<td style="user-select: auto;">2009-07-01</td>
</tr>
<tr style="user-select: auto;">
<td style="user-select: auto;">루피</td>
<td style="user-select: auto;">DR20090029</td>
<td style="user-select: auto;">CS</td>
<td style="user-select: auto;">2009-03-01</td>
</tr>
</tbody>
      </table>
<hr style="user-select: auto;">

<h5 style="user-select: auto;">주의사항</h5>

<p style="user-select: auto;">날짜 포맷은 예시와 동일하게 나와야합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges