[![Build Status](https://circleci.com/gh/mozafari/verdictdb/tree/master.svg?style=shield&circle-token=16a7386340ff7022b21ce007434f8caa2fa97aec)](https://circleci.com/gh/mozafari/verdictdb/tree/master)
[![Code Coverage](https://codecov.io/gh/mozafari/verdictdb/branch/master/graph/badge.svg)](https://codecov.io/gh/mozafari/verdictdb)

Aug 15, 2018: Now it works well for most common queries! We will update our online tutorial shortly. Anyone should be able to easily set up (with Maven central) and see huge speedups for MySQL, PostgreSQL, Impala, and Redshift. (The support for Spark is internally already done as well, so will be included shortly.)

Aug 2, 2018: We have almost finished the lastest update; just working on final quality checks.

July 29, 2018: We keep working on fix the bugs.

July 25 2018: The current documentation is out of date; it will be updated in a few days.


# Same SQL, Same DB, 100x-200x Faster Analytics

<p align="center">
<img src="http://verdictdb.org/image/verdict-for-impala-speedup.png" width="600px" />
</p>

Verdict brings you Interactive-speed, resource-efficient data analytics.

1. **200x faster by sacrificing only 1% accuracy**
   Verdict can give you 99% accurate answers for your big data queries in a fraction of the time needed for calculating exact answers. If your data is too big to analyze in a couple of seconds, you will like Verdict.
2. **No change to your database**
   Verdict is a middleware standing between your application and your database. You can just issue the same queries as before and get approximate answers right away. Of course, Verdict handles exact query processing too.
3. **Runs on (almost) any database**
   Verdict can run on any database that supports standard SQL. We already have drivers for Hive, Impala, and MySQL. We’ll soon add drivers for some other popular databases.
4. **Ease of use**
   Verdict is a client-side library: no servers, no port configurations, no extra user authentication, etc. You can simply make a JDBC connection to Verdict; then, Verdict automatically reads data from your database. Verdict is also shipped with a command-line interface.

Find more about Verdict at our website: [VerdictDB.org](http://verdictdb.org).


## Same SQL queries

When you issue standard SQL queries as below, Verdict internally converts the query into an alternative form that runs faster on your database. Verdict quickly returns an approximate answer to the query with an error bound (the true answer is within the error bound).

```sql
select city, count(*)
from big_data_table
where arbitrary_attr like '%what i want%'
group by city
order by count(*)
limit 10;
```

The alternative form includes a *sample table* instead of the original data. However, simiply replacing the original tables (e.g., `big_data_table`) with its sample table could result in largely incorrect answers. Verdict automatically handles such translations so its answers are accurate (1-2% within the exact answers).

All you need to do before observing such speedups is creating samples with just a single SQL expression.

```sql
create sample of big_data_table;
```


## Standard connection methods

<p align="center">
<img src="http://verdictdb.org/image/verdict-architecture.png" width="500px" />
</p>

Verdict supports the standard interface such as JDBC. For Apache Spark, you can simply include Verdict's `jar` file and issue queries to Verdict's SQL context.

Due to its support for standard interface, Verdict integrates easily with popular front-end tools, such as Apache Zeppelin, Hue, Jupyter notebooks, and so on.



## Download and install

You only need to download a couple of jar files to get started. Verdict does not require "sudo" access or any complicated setup process. Go to [this download page](http://verdictdb.org/download/) to find out the files relevant to your data analytics platforms. We already provide pre-built jar files for Cloudera distributions, MapR distributions, and official Apache Spark. You can also build from the source code using the standard build tool, Apache Maven.



## Research

Verdict speeds up **aggregate queries**, for which a tiny fraction of the entire data can be used instead for producing highly accurate answers. There are many theories and optimizations as well we developed and implemented inside Verdict for high accuracy and great efficiency. Visit our [research page](http://verdictdb.org/documentation/research/) and see innovations we make.


## Free for every use

We maintain Verdict for free under the Apache License so that anyone can benefit from our contributions. If you like our project, please star our Github repository (https://github.com/mozafari/verdict) and send feedback to verdict-user@umich.edu.

