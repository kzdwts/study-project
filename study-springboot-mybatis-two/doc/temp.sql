use leadnews_article;
#
select aa.id,
       aa.title,
       aa.author_name,
       aa.channel_name,
       aac.content
from ap_article aa
         left join ap_article_content aac on aa.id = aac.article_id
where aa.title like concat('%', 'java', '%')
