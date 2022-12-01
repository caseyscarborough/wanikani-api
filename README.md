## Wanikani V2 API Java Client

This library is a Java wrapper for the [Wanikani V2 API](https://docs.api.wanikani.com/).

## Usage

### Dependency

Add JitPack to your `build.gradle` with the dependency:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.caseyscarborough:wanikani-api:master'
}
```

### Basic Usage

```java
// Create a client with your API token
WaniKaniClient client = new WaniKaniClient("my-api-token");

// Basic methods use a simple format like the following
Summary summary = client.getSummary();

// Some others API methods require a request body, but the requests all use a
// builder format so you can easily see the parameters the request takes.

// Retrieve all level 60 Kanji:
SubjectsRequest request = SubjectsRequest.builder()
    .addType(SubjectType.KANJI)
    .levels(60)
    .build();
List<Subject> subjects = client.getSubjects(request);
```

The full list of implemented API methods is available in [this class](https://github.com/caseyscarborough/wanikani-api/blob/master/src/main/java/com/wanikani/api/v2/WaniKaniClient.java).

### Handling Pagination

By default, API responses are limited to 1000 items. If you are calling
an endpoint and expect to retrieve more than 1000 items, you can paginate
by doing the following:

```java
// Retrieve all vocabulary words from level 1-30
SubjectsRequest.Builder builder = SubjectsRequest.builder()
    .levels(IntStream.range(1, 31))
    .addType(SubjectType.VOCABULARY);

List<Subject> subjects = new ArrayList<>();

for (;;) {
    List<Subject> response = client.getSubjects(builder.build());
    
    // If the response is empty, there are no more items.
    if (response.isEmpty()) break;
    
    subjects.addAll(response);
    
    // Set the ID of the last item into our next request
    builder.pageAfterId(response.get(response.size() - 1).getId());
}
```

## Issues or Contributing

If you find an issue, have a question, or would like to request a feature please [open an issue](https://github.com/caseyscarborough/wanikani-api/issues).

Please also feel free to contribute by [opening a pull request](https://github.com/caseyscarborough/wanikani-api/pulls).
