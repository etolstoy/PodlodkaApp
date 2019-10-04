# Podlodka Podcast Mobile Application

It's a mobile app for [Podlodka Podcast](podlodka.io), entirely written using Kotlin Multiplatform. The work is in progress.

## Structure
- **iOS** – iOS Application
- **app** - Android Application
- **Backend** - Spring backend
- **SharedCode** - shared business logic for both apps

## Plans
- [ ] List of all previous episodes
- [ ] Schedule of future episodes
- [ ] Voting for next topics
- [ ] List of all guests
- [ ] Full-text search in episodes content
- [ ] Episodes playback
- [ ] Hosts statistics
- [ ] Unique possibility to pay money directly
- [ ] Clicker game

## Guides
### Updating backend
Local:
```
./gradlew clean dockerPush
```

On server:
```
docker rm -f CONTAINER_ID
docker run -d --name mongo mongo
docker run -d -p 0.0.0.0:80:8080/tcp --name podlodka --link=mongo etolstoy/podlodka 
```
