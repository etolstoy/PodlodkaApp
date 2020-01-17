package ru.podlodka.backend.service

import org.springframework.stereotype.Service
import ru.podlodka.backend.models.*
import ru.podlodka.backend.repositories.CategoryRepository
import ru.podlodka.backend.repositories.SelectionRepository
import ru.podlodka.backend.repositories.ShowEpisodeRepository

@Service
class MockDataService(val showEpisodeRepository: ShowEpisodeRepository,
                      val categoryRepository: CategoryRepository,
                      val selectionRepository: SelectionRepository) {
    // Генерация семпловых данных
    fun mockData(): String {
        showEpisodeRepository.deleteAll()
        categoryRepository.deleteAll()
        selectionRepository.deleteAll()

        val episodes = mutableListOf<ShowEpisode>()
        for (i in 1..20) {
            val guests = listOf<Person>(generatePerson())

            val episode = ShowEpisode(
                    id = generateRandomString(),
                    name = generateEpisodeName(),
                    number = i,
                    created = generateRandomCreated(),
                    length = generateRandomLength(),
                    desc = generateRandomString(),
                    hosts = generateHosts(),
                    guests = guests,
                    links = generateLinks(),
                    src = "https://soundcloud.com/podlodka/podlodka-126-osoznannost",
                    categories = emptyList(),
                    selections = emptyList()
            )
            episodes += episode
            showEpisodeRepository.insert(episode)
        }

        val categoryNames = listOf<String>("Мобильная разработка", "Тестирование", "Менеджмент", "Дизайн", "Психология")
        val categoryEmojis = listOf<String>("📱", "🐞", "💼", "🎨", "🧠")
        for (i in 0..4) {
            val category = Category(
                    id = generateRandomString(),
                    name = categoryNames[i],
                    emoji = categoryEmojis[i],
                    episodes = episodes.slice(5*i..5*i+4)
            )
            for (episode in episodes.slice(5*i..5*i+4)) {
                episode.categories += category
            }

            categoryRepository.insert(category)
        }

        val selectionNames = listOf<String>("Как поднять зарплату", "Как пройти собеседование", "Как подсидеть тимлида", "Как сделать нормальную архитектуру", "Как войти в IT")
        val selectionCovers = listOf<String>("https://images.unsplash.com/photo-1553729459-efe14ef6055d", "https://images.unsplash.com/photo-1549923746-c502d488b3ea", "https://images.unsplash.com/photo-1484981138541-3d074aa97716", "https://images.unsplash.com/photo-1431576901776-e539bd916ba2", "https://images.unsplash.com/photo-1573164713347-df1f7d6aeb03")
        for (i in 0..4) {
            val selection = Selection(
                    id = generateRandomString(),
                    name = selectionNames[i],
                    imageUrl = selectionCovers[i],
                    episodes = episodes.slice(5*i..5*i+4)
            )
            for (episode in episodes.slice(5*i..5*i+4)) {
                episode.selections += selection
            }

            selectionRepository.insert(selection)
        }

        return "ok";
    }

    fun generatePerson(): Person {
        return Person(
                generateRandomString(),
                generatePersonName(),
                generateRandomString(),
                generateCompany(),
                generatePhoto()
        )
    }

    private fun generatePhoto(): String {
        return "https://pbs.twimg.com/profile_images/1189904323767078913/jO5X2gDG_400x400.jpg"
    }

    fun generateRandomString(): String {
        return java.util.UUID.randomUUID().toString()
    }

    fun generatePersonName(): String {
        val names = listOf<String>("Иван", "Егор", "Владимир", "Петр", "Алексей", "Сергей", "Вячеслав", "Денис", "Борис", "Николай", "Эдуард")
        val surnames = listOf<String>("Иванов", "Петров", "Толстой", "Цыганов", "Кателла", "Путин", "Аскорбинов", "Гейтс", "Джобс", "Талеб", "Обама")

        return names.shuffled().take(1)[0] + " " + surnames.shuffled().take(1)[0]
    }

    fun generateCompany(): String {
        val names = listOf<String>("Авито", "Яндекс", "JetBrains", "Туту", "Роскачество", "Mail.Ru", "Утконос")
        return names.shuffled().take(1)[0]
    }

    fun generateEpisodeName(): String {
        val part1 = listOf<String>("Теория", "Практика", "Особенности", "Применение", "Боль и ужасы", "Судьба", "Использование")
        val part2 = listOf<String>("Go ", "Rust", "Swift", "Kotlin", "баз данных", "эмпатии", "эмоционального интеллекта", "тестирования", "программирования", "языков программирования", "инцидент-менеджмента", "осознанности", "жизни", "PHP", "фронтенда")

        return part1.shuffled().take(1)[0] + " " + part2.shuffled().take(1)[0]
    }

    fun generateLinks(): List<Link> = listOf<Link>(
            Link(
                    id = generateRandomString(),
                    name = "iTunes",
                    url = "https://apple.co/2Tr7vBf"
            ),
            Link(
                    id = generateRandomString(),
                    name = "Сайт",
                    url = "podlodka.io/128"
            ),
            Link(
                    id = generateRandomString(),
                    name = "Я.Музыка",
                    url = "http://bit.ly/2ZuiYm4"
            )
    )

    fun generateRandomLength(): Int = (3000..10000).random()
    fun generateRandomCreated(): Int = (1556000000..1580100000).random()

    fun generateHosts(): List<Person> = listOf<Person>(
            Person(
                    generateRandomString(),
                    "Егор Толстой",
                    generateRandomString(),
                    "Авито",
                    "https://pbs.twimg.com/profile_images/1189904323767078913/jO5X2gDG_400x400.jpg"
            ),
            Person(
                    generateRandomString(),
                    "Стас Цыганов",
                    generateRandomString(),
                    "Туту",
                    "https://pbs.twimg.com/profile_images/1189904323767078913/jO5X2gDG_400x400.jpg"
            ),
            Person(
                    generateRandomString(),
                    "Катя Петрова",
                    generateRandomString(),
                    "Авито",
                    "https://pbs.twimg.com/profile_images/1189904323767078913/jO5X2gDG_400x400.jpg"
            ),
            Person(
                    generateRandomString(),
                    "Евгений Кателла",
                    generateRandomString(),
                    "Яндекс",
                    "https://pbs.twimg.com/profile_images/1189904323767078913/jO5X2gDG_400x400.jpg"
            )
    )
}