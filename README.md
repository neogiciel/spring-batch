## <h1>Application Spring Batch</h1>
***
<table>
  <tr>
    <td><img src="https://blog.mossroy.fr/wp-content/uploads/2019/09/spring-boot-logo.png" alt="drawing" height="280px"/></td>
    <td>
      <img src="https://github.com/neogiciel/spring-batch/assets/123723616/8a9cd7d3-586e-4a38-b777-987f39598c8a" alt="drawing" height="280px"/>
    </td>
  </tr>
</table>

## Informations Générales
***
Mise en place d'un batch spring. Avec l'utilisation des librairies spring-batch et spring-quartz.
Cet exemple s'accompagne de la mise en place d'un base de données H2 afin d'effectuer le suivit des job. 

## Technologies
***
Technologies utilisées:
* Java 17 
* Maven 3.6
* Spring-boot: 3.2

## Instalation
***
Lancement de l'application Spring-boot<br>
```
$ mvn  clean
$ mvn spring-boot:run
```
Le service est accessible sur http://localhost:8080<br>
La console de base de données H2 est accessible via l'url  http://localhost:8080/h2-console

## FAQs
***
**Mise en place d'une Tache schedule**<br>

La mise en place d'un tache scheduler peur se faire de deux manières<br>
* Via des annotations
```
@Configuration
@EnableAsync
@EnableScheduling
public class SimpleScheduledTask {

    @Scheduled(fixedRate=5000)
    //@Scheduled(cron = "0 0 * * * *")
    public void test() throws Exception{
```
* Via de la programmation pure
```
//Job Creation
JobDataMap map = new JobDataMap();
map.put("message", "SimpleJob");
JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity("SimpleJob", "group1").setJobData(map).build();
			
//Simple Trigger
Date startTime = DateBuilder.nextGivenSecondDate(null, 10);
SimpleTrigger trigger = TriggerBuilder
		.newTrigger()
		.withIdentity("FourTimesTrigger", "group1")
		.startAt(startTime)
		.withSchedule(SimpleScheduleBuilder.simpleSchedule()
		.withIntervalInSeconds(10)
		.withRepeatCount(4)).build();
		
//Scheduler
SchedulerFactory sf = new StdSchedulerFactory();
Scheduler scheduler = sf.getScheduler();
scheduler.start();
scheduler.scheduleJob(job, trigger);

```


