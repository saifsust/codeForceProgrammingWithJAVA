FIRST QUERY : 
SELECT 
       D.delegateagentcond_id,
       D.delegate_id,
       D.agent_id,
       D.max_qps,
       D.max_qpm,
       D.max_connection,
       D.create_time,
       D.update_time,
       case
        when  D.agent_id  then    (select  A.agent_type    from AGENTS A where  A.agent_id = D.agent_id)
       end as agent_type,
	  case
        when  D.agent_id  then    (select  A.license_expire_date  from AGENTS A where  A.agent_id = D.agent_id)
       end as license_expire_date

	
 FROM   DELEGATEAGENTCONDS D where D.agent_id in ( select agent_id from AGENTS  A where  A.delete_flag = 0  and  ((A.agent_type = 4 and A.license_expire_date > Now()) or  A.agent_type != 4))  
## Fetch time 1.28.96

SECOND QUERY:

SELECT D.delegateagentcond_id,
       D.delegate_id,
       D.agent_id,
       D.max_qps,
       D.max_qpm,
       D.max_connection,
       D.create_time,
       D.update_time,
       A.agent_type,
       A.license_expire_date
FROM   DELEGATEAGENTCONDS D , AGENTS A
               where A.agent_id = D.agent_id
 and  A.delete_flag = 0
       AND ( ( A.agent_type = 4
               AND A.license_expire_date > Now() )
              OR A.agent_type != 4 )
ORDER  BY D.create_time,
          D.delegateagentcond_id


## fetch time 1.34.47
