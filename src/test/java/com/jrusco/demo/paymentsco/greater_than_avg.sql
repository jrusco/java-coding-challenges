-- get cities with more than avg count of customers
SELECT country.country_name, city.city_name, count_by_city.customers as customer_qty
FROM city, country, 
	(-- count of customers per city
    SELECT city_id, COUNT(id) as customers
	FROM adyen.customer
	GROUP BY city_id) as count_by_city
WHERE count_by_city.city_id = city.id AND country.id = city.country_id
GROUP BY count_by_city.city_id
HAVING count_by_city.customers > 
	(-- average count of customers per city
    SELECT AVG(count_by_city.customers) 
    FROM (SELECT COUNT(id) as customers FROM adyen.customer GROUP BY city_id) as count_by_city)
ORDER BY country.country_name, city.city_name;
