select * from visitor;

insert into visitor(ip,funnel,date)
(select '127.0.0.1' as ip,'revisit' as funnel,now() as date
from visitor 
where exists (select * from visitor where date between date_sub(now(),interval 1 hour) and now() and ip = '127.0.0.1') and ip = '127.0.0.1'
order by date desc
limit 1)
union all
(select '127.0.0.1' as ip, 'googleSearch' as funnel, now() as date
from visitor
where not exists (select * from visitor where date between date_sub(now(),interval 1 hour) and now() and ip = '127.0.0.1') and ip = '127.0.0.1'
order by date desc
limit 1
);

select date_format(uo_date,'%y-%m-%d') as aa, count(uod_id)
from user_order_detail uod,user_order uo
left join visitor on date_format(date,'%y-%m-%d') = date_format(uo_date,'%y-%m-%d')
where uo.uo_id = uod.uo_id 
and DATE(uo_date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(uo_date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by aa;

select date_format(date,'%y-%m-%d') as bb, count(visitor_id) as pv
from visitor 
where DATE(date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by bb;

select b.bb as date ,b.pv AS PAGEVIEW,c.uv AS UNIQUEVISITOR, a.ordercount,d.signupcount
from
(select date_format(uo_date,'%y-%m-%d') as aa, count(uod_id) as ordercount,max(p_id) as p_id
from user_order_detail uod,user_order uo 
where uo.uo_id = uod.uo_id 
and DATE(uo_date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(uo_date) <= STR_TO_DATE('2022-04-30', '%y-%m-%d')
group by aa) as a
right join
(select date_format(date,'%y-%m-%d') as bb, count(visitor_id) as pv
from visitor
where DATE(date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by bb) as b
on b.bb = a.aa
left join
(select date_format(date,'%y-%m-%d') as cc, count(visitor_id) as uv
from visitor 
where funnel not in ('revisit')
and DATE(date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by cc) as c
on b.bb =c.cc
left join
(select date_format(u_registerdate,'%y-%m-%d') as dd, count(u_id) as signupcount 
from user
where 
DATE(u_registerdate) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(u_registerdate) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by dd) as d
on b.bb = d.dd
;

select date_format(uo_date,'%y-%m-%d') as date
from user_order_detail uod,user_order uo 
where uo.uo_id = uod.uo_id 
and DATE(uo_date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(uo_date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by date
having 

;


-- elect date_format(uo_date,'%y-%m-%d') as aa
select *
from user_order_detail uod,user_order uo
where uo.uo_id = uod.uo_id;

select  concat(year(uo_date),'-', month(uo_date),'-', week(uo_date)) as aa, count(uod_id) from user_order_detail uod,user_order uo where uo.uo_id = uod.uo_id 
group by aa;

select a.aa
from
(select date_format(uo_date,'%Y-%m-%d') as aa, count(uod_id) as ordercount,max(p_id) as p_id
from user_order_detail uod,user_order uo 
where uo.uo_id = uod.uo_id 
and DATE(uo_date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(uo_date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by aa) as a;

		SELECT A.AA
		FROM
		(SELECT DATE_FORMAT(UO_DATE,'%Y-%m-%d') as aa, count(uod_id) as ordercount,max(p_id) as p_id
		FROM USER_ORDER_DETAIL UOD,USER_ORDER UO 
		WHERE UO.UO_ID = UOD.UO_ID 
		and DATE(uo_date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
		AND DATE(uo_date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
		GROUP BY AA) AS A;
		
        SELECT A.AA
		FROM
		(SELECT DATE_FORMAT(UO_DATE,'%Y-%m') AS AA, COUNT(UOD_ID) AS ORDERCOUNT,MAX(P_ID) AS P_ID
		FROM USER_ORDER_DETAIL UOD,USER_ORDER UO 
		WHERE UO.UO_ID = UOD.UO_ID 
		AND DATE(UO_DATE) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
		AND DATE(UO_DATE) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d') 
		GROUP BY AA) AS A
		;
        

select *
from(

select date_format(uo_date,'%y-%m-%d') as aa, count(uod_id) as ordercount, max(p_id) as p_id 
from user_order_detail uod,user_order uo 
where uo.uo_id = uod.uo_id 
and DATE(uo_date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(uo_date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by aa
) as a;

--  최대 구매상품 id
select date, max(p_id) as p_id, max(max) as count
from 
(select a.aa as date , max(acnt) as max
from
(select count(p_id) as acnt, p_id, date_format(uo_date,'%y-%m-%d') as aa
from user_order_detail uod,user_order uo 
where uo.uo_id = uod.uo_id 
and DATE(uo_date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(uo_date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by aa,p_id) as a
group by a.aa) as b
join
(select count(p_id) as acnt, p_id, date_format(uo_date,'%y-%m-%d') as aa
from user_order_detail uod,user_order uo 
where uo.uo_id = uod.uo_id 
and DATE(uo_date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(uo_date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by aa,p_id) as c
on b.max = c.acnt and b.date = c.aa 
group by date
order by date desc
;
-- 
select date, max(funnel), max(maxpv)
from
(select bb as date,max(pv) as maxpv
from
(select date_format(date,'%Y-%m-%d') as bb, count(visitor_id) as pv , funnel 
from visitor
where DATE(date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by bb ,funnel) as tmp1
group by tmp1.bb) as tmp2
join
(select date_format(date,'%Y-%m-%d') as bb, count(visitor_id) as pv , funnel 
from visitor
where DATE(date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by bb,funnel) as tmp3
on tmp2.maxpv = tmp3.pv and tmp2.date = tmp3.bb
group by date
order by date desc
;


select bb as date, max(pv) as maxpv
from
(select date_format(date,'%Y-%m-%d') as bb, count(visitor_id) as pv , funnel 
from visitor
where DATE(date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by bb ,funnel) as tmp1
group by tmp1.bb;

select date_format(date,'%Y-%m-%d') as bb, count(visitor_id) as pv 
from visitor
where DATE(date) >= STR_TO_DATE('2022-04-10', '%Y-%m-%d') 
AND DATE(date) <= STR_TO_DATE('2022-04-30', '%Y-%m-%d')
group by bb;
