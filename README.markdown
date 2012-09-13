# Mono Loco

### Description
An chaos monkey implementation

### How it works
Every second, an Monkey impl is poked, by default, [DefaultMonkey](https://github.com/capotej/monoloco/blob/master/src/main/scala/com/twitter/monoloco/DefaultMonkey.scala) is used (this can be changed in App.scala).

An monkey extends [Monkey](https://github.com/capotej/monoloco/blob/master/src/main/scala/com/twitter/monoloco/Monkey.scala) and implements the following methods: shouldRun():Boolean, and apply():Unit

Monkey's use an [Trick](https://github.com/capotej/monoloco/blob/master/src/main/scala/com/twitter/monoloco/Trick.scala) to do their work, see [ChoppyNetwork](https://github.com/capotej/monoloco/blob/master/src/main/scala/com/twitter/monoloco/ChoppyNetwork.scala) and [KillTunnel](https://github.com/capotej/monoloco/blob/master/src/main/scala/com/twitter/monoloco/KillTunnel.scala) for examples. The DefaultMonkey randomly picks from a List of Tricks once a minute (roughly)

### Running/Deploying it
mvn package will generate a fatjar in target/monoloco-0.0.1-SNAPSHOT-jar-with-dependencies.jar which
you can scp to a server and just java -jar it. It will leave logs in logs/monoloco.log
