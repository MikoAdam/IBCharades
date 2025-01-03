package com.example.ibcharades

object Decks {
    val exampleDecks = mapOf(
        "Acting" to listOf(
            "Swimming", "Driving a Car", "Dancing", "Running", "Flying a Plane", "Playing Guitar",
            "Typing on a Keyboard", "Eating", "Sleeping", "Crying", "Laughing", "Brushing Teeth",
            "Climbing", "Boxing", "Fishing", "Painting", "Skiing", "Playing Soccer", "Reading",
            "Riding a Horse"
        ),
        "Countries" to listOf(
            "Germany", "France", "Japan", "Brazil", "Australia", "Canada", "Mexico", "India",
            "China", "Russia", "South Africa", "Italy", "Spain", "Portugal", "Sweden", "Norway",
            "Argentina", "Chile", "Egypt", "Kenya", "Poland", "Greece", "Iceland", "Turkey",
            "Ireland", "Netherlands", "Denmark", "Finland", "Saudi Arabia", "South Korea",
            "New Zealand", "Ukraine", "Peru", "Colombia", "Thailand", "Vietnam", "Malaysia"
        ),
        "Capitals" to listOf(
            "Berlin", "Paris", "Tokyo", "Brasilia", "Canberra", "Ottawa", "Mexico City",
            "New Delhi", "Beijing", "Moscow", "Pretoria", "Rome", "Madrid", "Lisbon",
            "Stockholm", "Oslo", "London", "Washington", "Cairo", "Ankara", "Buenos Aires",
            "Bangkok", "Kuala Lumpur", "Seoul", "Lima", "Santiago", "Athens", "Helsinki",
            "Dublin", "Wellington", "Jakarta", "Riyadh", "Islamabad", "Baghdad", "Tehran"
        ),
        "Animals" to listOf(
            "Elephant", "Tiger", "Kangaroo", "Penguin", "Eagle", "Lion", "Zebra", "Dolphin",
            "Shark", "Whale", "Rabbit", "Frog", "Snake", "Wolf", "Bear", "Leopard", "Giraffe",
            "Cheetah", "Rhinoceros", "Hippopotamus", "Tortoise", "Crocodile", "Alligator",
            "Camel", "Horse", "Sheep", "Cow", "Goat", "Chicken", "Duck", "Parrot", "Monkey",
            "Chimpanzee", "Panda", "Fox", "Raccoon", "Owl", "Bison", "Hawk", "Falcon", "Deer"
        ),
        "Movies" to listOf(
            "Titanic", "Inception", "Avatar", "The Godfather", "Pulp Fiction", "Gladiator",
            "The Matrix", "Jurassic Park", "Star Wars", "The Dark Knight", "Forrest Gump",
            "Back to the Future", "Harry Potter", "The Lord of the Rings", "The Avengers",
            "Spider-Man", "Frozen", "The Lion King", "Shrek", "Toy Story", "Jaws", "Rocky",
            "Terminator", "Finding Nemo", "Aladdin", "The Wizard of Oz", "Schindler's List",
            "The Shawshank Redemption", "The Silence of the Lambs", "Casablanca", "La La Land"
        ),
        "Celebrities" to listOf(
            "Brad Pitt", "Angelina Jolie", "Leonardo DiCaprio", "Meryl Streep", "Tom Cruise",
            "Johnny Depp", "Scarlett Johansson", "Chris Hemsworth", "Jennifer Lawrence",
            "Robert Downey Jr.", "Will Smith", "Natalie Portman", "Emma Watson", "Daniel Radcliffe",
            "Hugh Jackman", "Dwayne Johnson", "Taylor Swift", "Kanye West", "Beyoncé", "Lady Gaga",
            "Rihanna", "Drake", "Ed Sheeran", "Justin Bieber", "Selena Gomez", "Billie Eilish",
            "Keanu Reeves", "Margot Robbie", "Zendaya", "Gal Gadot", "Tom Hanks", "Morgan Freeman"
        ),
        "Fruits" to listOf(
            "Apple", "Banana", "Orange", "Pineapple", "Strawberry", "Watermelon", "Grape",
            "Cherry", "Lemon", "Mango", "Papaya", "Pear", "Peach", "Plum", "Kiwi", "Blueberry",
            "Raspberry", "Fig", "Coconut", "Guava", "Apricot", "Avocado", "Cantaloupe", "Cranberry",
            "Grapefruit", "Lychee", "Melon", "Nectarine", "Olive", "Pomegranate", "Tangerine"
        ),
        "Vegetables" to listOf(
            "Carrot", "Potato", "Tomato", "Cucumber", "Spinach", "Lettuce", "Onion", "Garlic",
            "Pepper", "Broccoli", "Cauliflower", "Zucchini", "Pumpkin", "Mushroom", "Radish",
            "Eggplant", "Cabbage", "Celery", "Beetroot", "Turnip", "Kale", "Asparagus", "Peas",
            "Corn", "Artichoke", "Brussels Sprouts", "Leek", "Chili", "Okra", "Bamboo Shoots"
        ),
        "Professions" to listOf(
            "Doctor", "Engineer", "Teacher", "Artist", "Writer", "Actor", "Pilot", "Chef",
            "Nurse", "Police Officer", "Firefighter", "Dentist", "Scientist", "Lawyer", "Journalist",
            "Plumber", "Electrician", "Architect", "Pharmacist", "Therapist", "Surgeon", "Librarian",
            "Musician", "Photographer", "Designer", "Mechanic", "Driver", "Carpenter", "Builder",
            "Veterinarian", "Translator", "Accountant", "Programmer", "Psychologist"
        ),
        "Sports" to listOf(
            "Football", "Basketball", "Tennis", "Cricket", "Baseball", "Rugby", "Golf", "Hockey",
            "Badminton", "Swimming", "Cycling", "Skiing", "Snowboarding", "Skating", "Wrestling",
            "Boxing", "Martial Arts", "Judo", "Karate", "Taekwondo", "Archery", "Fencing", "Rowing",
            "Diving", "Sailing", "Gymnastics", "Surfing", "Skateboarding", "Volleyball", "Handball"
        ),
        "Colors" to listOf(
            "Red", "Blue", "Green", "Yellow", "Purple", "Orange", "Pink", "Black", "White",
            "Gray", "Brown", "Magenta", "Turquoise", "Cyan", "Lavender", "Beige", "Ivory",
            "Navy", "Gold", "Silver", "Coral", "Maroon", "Teal", "Olive", "Indigo", "Violet"
        ),
        "Instruments" to listOf(
            "Guitar", "Piano", "Violin", "Drums", "Flute", "Saxophone", "Trumpet", "Harp",
            "Trombone", "Cello", "Clarinet", "Accordion", "Bagpipes", "Mandolin", "Ukulele",
            "Banjo", "Harmonica", "Xylophone", "Bass", "Oboe", "Tuba", "Tambourine", "Triangle",
            "Cymbals", "Lute", "French Horn", "Synthesizer", "Recorder", "Zither", "Viola"
        ),
        // Add more decks with similar structures to fill up to 50 decks
        // You can add themes such as Jobs, Foods, Vehicles, Nature, Science, etc.
        "Jobs" to listOf(
            "Accountant", "Baker", "Barber", "Butcher", "Carpenter", "Chef", "Cleaner",
            "Construction Worker", "Consultant", "Designer", "Developer", "Doctor",
            "Driver", "Engineer", "Farmer", "Firefighter", "Hairdresser", "Journalist",
            "Lawyer", "Manager", "Mechanic", "Nurse", "Photographer", "Pilot",
            "Plumber", "Police Officer", "Postman", "Scientist", "Teacher", "Veterinarian"
        ),
        "Vehicles" to listOf(
            "Car", "Bicycle", "Motorcycle", "Airplane", "Boat", "Bus", "Truck", "Scooter",
            "Tractor", "Helicopter", "Train", "Submarine", "Skateboard", "Yacht", "Canoe",
            "Ferry", "Cruise Ship", "Taxi", "Ambulance", "Fire Truck", "Police Car", "Spaceship",
            "Segway", "Hoverboard", "Trolley", "Glider", "Bulldozer", "Jet Ski", "Sailboat"
        ),
        "Planets" to listOf(
            "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",
            "Pluto", "Europa", "Io", "Titan", "Ganymede", "Callisto", "Enceladus",
            "Triton", "Ceres", "Eris", "Haumea", "Makemake", "Phobos", "Deimos"
        ),
        "Famous Landmarks" to listOf(
            "Eiffel Tower", "Great Wall of China", "Statue of Liberty", "Machu Picchu", "Colosseum",
            "Taj Mahal", "Pyramids of Giza", "Big Ben", "Mount Everest", "Sydney Opera House",
            "Christ the Redeemer", "Stonehenge", "Golden Gate Bridge", "Angkor Wat", "Burj Khalifa",
            "Leaning Tower of Pisa", "Petra", "Acropolis", "Niagara Falls", "Grand Canyon"
        ),
        "Countries' National Dishes" to listOf(
            "Sushi (Japan)", "Pizza (Italy)", "Tacos (Mexico)", "Paella (Spain)", "Poutine (Canada)",
            "Curry (India)", "Pho (Vietnam)", "Falafel (Middle East)", "Fish and Chips (UK)",
            "Kebab (Turkey)", "Croissant (France)", "Bratwurst (Germany)", "Kimchi (South Korea)",
            "Borscht (Ukraine)", "Feijoada (Brazil)", "Churrasco (Argentina)", "Dumplings (China)"
        ),
        "Superheroes" to listOf(
            "Superman", "Batman", "Spider-Man", "Wonder Woman", "Iron Man", "Captain America",
            "Hulk", "Thor", "Black Panther", "The Flash", "Aquaman", "Doctor Strange", "Wolverine",
            "Green Lantern", "Ant-Man", "Scarlet Witch", "Daredevil", "Deadpool", "Black Widow"
        ),
        "Famous Books" to listOf(
            "1984", "To Kill a Mockingbird", "Pride and Prejudice", "The Great Gatsby", "Moby Dick",
            "War and Peace", "The Catcher in the Rye", "The Lord of the Rings", "The Hobbit",
            "Harry Potter", "The Chronicles of Narnia", "Brave New World", "Crime and Punishment",
            "Anna Karenina", "The Odyssey", "Jane Eyre", "The Alchemist", "The Da Vinci Code"
        ),
        "Musical Instruments (Acting)" to listOf(
            "Guitar", "Violin", "Drums", "Flute", "Piano", "Saxophone", "Trumpet", "Harp", "Accordion",
            "Trombone", "Cello", "Clarinet", "Tambourine", "Bagpipes", "Triangle"
        ),
        "Famous Inventions" to listOf(
            "Light Bulb", "Telephone", "Airplane", "Computer", "Television", "Internet", "Printing Press",
            "Steam Engine", "Camera", "Car", "Radio", "Vaccines", "Microscope", "Penicillin", "Electricity",
            "X-ray Machine", "Satellite", "Smartphone", "Rocket", "GPS", "Laser"
        ),
        "Famous Athletes" to listOf(
            "Michael Jordan", "Serena Williams", "Usain Bolt", "Lionel Messi", "Cristiano Ronaldo",
            "Roger Federer", "LeBron James", "Tiger Woods", "Simone Biles", "Muhammad Ali",
            "Michael Phelps", "Neymar", "Tom Brady", "Kobe Bryant", "Shaquille O'Neal",
            "David Beckham", "Rafael Nadal", "Novak Djokovic", "Mike Tyson", "Wayne Gretzky"
        ),
        "World Cities" to listOf(
            "New York", "London", "Tokyo", "Paris", "Los Angeles", "Moscow", "Dubai", "Rome",
            "Istanbul", "Sydney", "Shanghai", "Mumbai", "Bangkok", "Rio de Janeiro", "Hong Kong",
            "Toronto", "Seoul", "Mexico City", "Cairo", "Berlin", "Singapore", "Chicago",
            "Madrid", "Beijing", "Vienna", "Lisbon", "Amsterdam", "Buenos Aires", "Prague"
        ),
        "Famous Historical Figures" to listOf(
            "Julius Caesar", "Napoleon Bonaparte", "George Washington", "Cleopatra", "Alexander the Great",
            "Mahatma Gandhi", "Winston Churchill", "Albert Einstein", "Marie Curie", "Leonardo da Vinci",
            "Galileo Galilei", "Nelson Mandela", "Abraham Lincoln", "Joan of Arc", "Martin Luther King Jr.",
            "Isaac Newton", "Charles Darwin", "Mother Teresa", "Karl Marx", "Walt Disney"
        ),
        "Fairy Tale Characters" to listOf(
            "Cinderella", "Snow White", "The Little Mermaid", "Pinocchio", "Aladdin", "Peter Pan",
            "Hansel", "Gretel", "Sleeping Beauty", "Rapunzel", "The Big Bad Wolf", "Goldilocks",
            "Little Red Riding Hood", "Beauty and the Beast", "The Ugly Duckling", "Puss in Boots",
            "Jack (Jack and the Beanstalk)", "Robin Hood", "King Arthur", "Rumpelstiltskin"
        ),
        "Famous Explorers" to listOf(
            "Christopher Columbus", "Marco Polo", "Vasco da Gama", "Ferdinand Magellan", "Hernán Cortés",
            "James Cook", "Lewis and Clark", "Neil Armstrong", "Yuri Gagarin", "Ibn Battuta",
            "Amelia Earhart", "Roald Amundsen", "Jacques Cousteau", "Hernando de Soto", "Francis Drake",
            "Zheng He", "David Livingstone", "Ernest Shackleton", "Leif Erikson", "Henry Hudson"
        ),
        "Famous TV Shows" to listOf(
            "Friends", "Breaking Bad", "Game of Thrones", "The Simpsons", "Stranger Things",
            "The Office", "Sherlock", "The Crown", "The Walking Dead", "Seinfeld", "House of Cards",
            "Grey’s Anatomy", "How I Met Your Mother", "The Big Bang Theory", "Westworld",
            "Parks and Recreation", "Lost", "Better Call Saul", "Mad Men", "Black Mirror"
        ),
        "Brands and Companies" to listOf(
            "Apple", "Google", "Microsoft", "Amazon", "Tesla", "Facebook", "Nike", "Coca-Cola",
            "Samsung", "BMW", "Toyota", "McDonald's", "Adidas", "Pepsi", "Sony", "Starbucks",
            "Netflix", "IKEA", "Disney", "Ferrari", "Mercedes-Benz", "Uber", "Airbnb", "Rolex"
        ),
        "Famous Paintings" to listOf(
            "Mona Lisa", "The Starry Night", "The Last Supper", "Girl with a Pearl Earring",
            "The Scream", "The Persistence of Memory", "American Gothic", "The Birth of Venus",
            "Guernica", "The Night Watch", "The Kiss", "Water Lilies", "The Creation of Adam",
            "Liberty Leading the People", "The Arnolfini Portrait", "Whistler's Mother",
            "The School of Athens", "Las Meninas", "Self-Portrait (Vincent van Gogh)"
        ),
        "Hobbies" to listOf(
            "Reading", "Writing", "Painting", "Photography", "Gardening", "Knitting", "Cooking",
            "Fishing", "Hiking", "Birdwatching", "Traveling", "Dancing", "Playing Video Games",
            "Playing Chess", "Playing Cards", "Cycling", "Swimming", "Surfing", "Rock Climbing",
            "Pottery", "Scrapbooking", "Singing", "Playing Guitar", "Yoga", "Meditation"
        ),
        "Body Parts" to listOf(
            "Head", "Shoulder", "Knee", "Toe", "Elbow", "Finger", "Nose", "Ear", "Mouth", "Eye",
            "Hand", "Foot", "Ankle", "Wrist", "Neck", "Back", "Chest", "Stomach", "Leg", "Arm"
        ),
        "Foods" to listOf(
            "Pizza", "Burger", "Pasta", "Sushi", "Fried Chicken", "Salad", "Tacos", "Soup", "Ice Cream",
            "Steak", "Fries", "Bread", "Pancakes", "Omelette", "Curry", "Dumplings", "Lasagna",
            "Ramen", "Risotto", "Fajitas", "Paella", "BBQ Ribs", "Nachos", "Spaghetti", "Hot Dog"
        ),
        "Famous Authors" to listOf(
            "William Shakespeare", "J.K. Rowling", "George Orwell", "Charles Dickens", "Mark Twain",
            "Jane Austen", "Ernest Hemingway", "Leo Tolstoy", "Agatha Christie", "Stephen King",
            "J.R.R. Tolkien", "Fyodor Dostoevsky", "Virginia Woolf", "Gabriel García Márquez",
            "Haruki Murakami", "Franz Kafka", "Homer", "Oscar Wilde", "George R.R. Martin", "Dr. Seuss"
        ),
        "World War I" to listOf(
            "Archduke Franz Ferdinand", "Kaiser Wilhelm II", "Woodrow Wilson", "Tsar Nicholas II",
            "David Lloyd George", "Georges Clemenceau", "Battle of the Somme", "Trench Warfare",
            "No Man's Land", "U-Boat", "Lusitania", "Western Front", "Eastern Front", "Gallipoli Campaign",
            "Red Baron", "Zimmermann Telegram", "Treaty of Versailles", "League of Nations",
            "Central Powers", "Allied Powers", "Armistice", "Triple Entente", "War Guilt Clause",
            "Battle of Verdun", "Russian Revolution", "Chemical Warfare", "Wilsonian Democracy",
            "Bolsheviks", "Serbia", "Battle of Jutland"
        ),
        "Roman Empire" to listOf(
            "Julius Caesar", "Augustus", "Nero", "Constantine the Great", "Marcus Aurelius",
            "Roman Senate", "Gladiator", "Colosseum", "Roman Forum", "Pompeii", "Roman Legions",
            "Hannibal", "Carthage", "Pax Romana", "SPQR", "Aqueduct", "Hadrian's Wall",
            "Romulus and Remus", "Brutus", "Spartacus", "Cicero", "Trajan", "Caligula", "Tiberius",
            "The Punic Wars", "Cleopatra", "Roman Gods", "Pantheon", "Gaul", "Byzantine Empire"
        ),
        "Celestial Objects" to listOf(
            "Sun", "Moon", "Mars", "Jupiter", "Saturn", "Venus", "Mercury", "Pluto",
            "Andromeda Galaxy", "Milky Way", "Orion Nebula", "Alpha Centauri", "Betelgeuse", "Black Hole",
            "Comet", "Asteroid", "Supernova", "Neutron Star", "Quasar", "Exoplanet", "Europa",
            "Titan", "Ganymede", "Phobos", "Deimos", "Triton", "Hale-Bopp", "Meteor Shower", "Aurora Borealis",
            "Eclipse", "Sirius", "Proxima Centauri"
        ),
        "Latin America" to listOf(
            "Brazil", "Argentina", "Mexico", "Chile", "Colombia", "Peru", "Uruguay", "Paraguay",
            "Bolivia", "Ecuador", "Venezuela", "Cuba", "Panama", "Costa Rica", "Guatemala", "Honduras",
            "El Salvador", "Nicaragua", "Dominican Republic", "Puerto Rico", "Belize", "Guyana",
            "Suriname", "Falkland Islands", "Machu Picchu", "Amazon Rainforest", "Patagonia",
            "Tango", "Carnival", "Andes Mountains", "Mayan Civilization", "Inca Empire",
            "Aztec Empire", "Simón Bolívar", "Che Guevara", "Fidel Castro", "Eva Perón",
            "Diego Rivera", "Gabriel García Márquez", "Pablo Neruda", "Shakira",
            "Cuban Revolution", "Hugo Chávez", "Rio de Janeiro", "Buenos Aires",
            "Samba", "Tenochtitlan", "Lima", "Santiago", "Antonio Jose de Sucre", "Fernando de la Mora"
        ),
        "Venezuela" to listOf(
            "Simón Bolívar", "Hugo Chávez", "Caracas", "Lake Maracaibo", "Angel Falls",
            "Bolivarian Revolution", "Arepa", "Roraima", "Petroleum", "Orinoco River",
            "Nicolás Maduro", "Miss Venezuela", "Pabellón Criollo", "Guaido", "Bolívar",
            "Miranda", "Merida", "Táchira", "Zulia", "Coro", "Los Roques", "Venezuelan flag",
            "Colombian border", "Venezuelan Independence", "Venezuelan Bolivar",
            "Leopoldo López", "Carabobo", "Venezuelan War of Independence",
            "San Cristóbal", "Venezuelan Andes", "Venezuelan Llanos"
        ),
        "Famous Scientists" to listOf(
            "Isaac Newton", "Albert Einstein", "Marie Curie", "Nikola Tesla",
            "Galileo Galilei", "Charles Darwin", "Stephen Hawking", "Richard Feynman",
            "Gregor Mendel", "James Watson", "Rosalind Franklin", "Niels Bohr",
            "Alexander Fleming", "Dmitri Mendeleev", "Michael Faraday", "Thomas Edison",
            "Carl Sagan", "Leonardo da Vinci", "Ada Lovelace", "Alan Turing"
        ),
        "Dinosaurs" to listOf(
            "Tyrannosaurus Rex", "Triceratops", "Stegosaurus", "Velociraptor",
            "Brachiosaurus", "Pterodactyl", "Allosaurus", "Diplodocus",
            "Spinosaurus", "Ankylosaurus", "Iguanodon", "Parasaurolophus",
            "Compsognathus", "Deinonychus", "Archaeopteryx", "Pachycephalosaurus"
        ),
        "Famous Inventors" to listOf(
            "Thomas Edison", "Nikola Tesla", "Alexander Graham Bell", "Marie Curie",
            "Leonardo da Vinci", "James Watt", "Wright Brothers", "Galileo Galilei",
            "Steve Jobs", "Bill Gates", "Elon Musk", "Mark Zuckerberg", "Guglielmo Marconi",
            "Tim Berners-Lee", "Henry Ford", "Johannes Gutenberg", "Benjamin Franklin",
            "Samuel Morse", "George Washington Carver", "Hedy Lamarr"
        ),
        "Greek Mythology" to listOf(
            "Zeus", "Hera", "Poseidon", "Hades", "Athena", "Apollo", "Artemis",
            "Aphrodite", "Hermes", "Hephaestus", "Demeter", "Dionysus",
            "Persephone", "Achilles", "Odysseus", "Hercules", "Theseus", "Minotaur",
            "Medusa", "Pegasus", "Cerberus", "Narcissus", "Pandora", "Cyclops"
        ),
        "Famous Philosophers" to listOf(
            "Socrates", "Plato", "Aristotle", "Confucius", "Rene Descartes",
            "John Locke", "Karl Marx", "Immanuel Kant", "Jean-Paul Sartre",
            "Friedrich Nietzsche", "Simone de Beauvoir", "Voltaire", "David Hume",
            "Blaise Pascal", "Michel Foucault", "Albert Camus", "Thomas Hobbes",
            "Baruch Spinoza", "John Stuart Mill", "Epicurus"
        ),
        "Famous Composers" to listOf(
            "Ludwig van Beethoven", "Wolfgang Amadeus Mozart", "Johann Sebastian Bach",
            "Franz Schubert", "Pyotr Ilyich Tchaikovsky", "Antonio Vivaldi",
            "Franz Liszt", "Frederic Chopin", "George Frideric Handel",
            "Johannes Brahms", "Claude Debussy", "Richard Wagner", "Giuseppe Verdi",
            "Gustav Mahler", "Maurice Ravel", "Igor Stravinsky", "Sergei Rachmaninoff",
            "Aaron Copland", "Dmitri Shostakovich", "Philip Glass"
        ),
        "Famous Scientists" to listOf(
            "Albert Einstein", "Isaac Newton", "Marie Curie", "Charles Darwin",
            "Stephen Hawking", "Galileo Galilei", "Louis Pasteur", "Nikola Tesla",
            "Gregor Mendel", "Rosalind Franklin", "Richard Feynman", "Carl Sagan",
            "Neil deGrasse Tyson", "Dmitri Mendeleev", "Niels Bohr", "Max Planck",
            "James Clerk Maxwell", "Alan Turing", "Leonardo da Vinci", "Jane Goodall"
        ),
        "Disney Movies" to listOf(
            "The Lion King", "Aladdin", "Beauty and the Beast", "Frozen", "Moana",
            "The Little Mermaid", "Cinderella", "Mulan", "Sleeping Beauty",
            "Snow White and the Seven Dwarfs", "Tangled", "Pocahontas",
            "The Jungle Book", "Peter Pan", "Toy Story", "Monsters, Inc.",
            "Finding Nemo", "Zootopia", "Big Hero 6", "Wreck-It Ralph"
        ),
        "Mythical Creatures" to listOf(
            "Dragon", "Phoenix", "Unicorn", "Griffin", "Hydra", "Kraken",
            "Basilisk", "Sphinx", "Centaur", "Minotaur", "Mermaid",
            "Pegasus", "Chimera", "Werewolf", "Vampire", "Goblin",
            "Ogre", "Fairy", "Dwarf", "Cyclops"
        ),
        "Famous Battles" to listOf(
            "Battle of Waterloo", "Battle of Thermopylae", "Battle of Gettysburg",
            "Battle of Hastings", "Battle of Stalingrad", "Battle of Midway",
            "Battle of Marathon", "Siege of Constantinople", "Battle of Agincourt",
            "Battle of Tours", "Battle of Leipzig", "Battle of Gallipoli",
            "Battle of Verdun", "Battle of Saratoga", "Battle of Trafalgar",
            "Battle of the Bulge", "Battle of Yorktown", "Battle of the Somme",
            "Battle of Bunker Hill", "Battle of Antietam"
        ),
        "Space Missions" to listOf(
            "Apollo 11", "Voyager 1", "Hubble Space Telescope", "Mars Rover Curiosity",
            "Challenger", "Columbia", "Sputnik 1", "Vostok 1", "Juno",
            "Cassini", "New Horizons", "International Space Station", "Galileo",
            "Lunar Module", "Apollo 13", "Mars Pathfinder", "Gemini Program",
            "Space Shuttle Atlantis", "Soyuz", "Pioneer 10"
        ),
        "Famous Artists" to listOf(
            "Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet",
            "Salvador Dalí", "Frida Kahlo", "Michelangelo", "Rembrandt",
            "Andy Warhol", "Georgia O'Keeffe", "Paul Cézanne", "Jackson Pollock",
            "Henri Matisse", "Edvard Munch", "Caravaggio", "Diego Rivera",
            "Pierre-Auguste Renoir", "Edgar Degas", "Gustav Klimt", "Jean-Michel Basquiat"
        ),
        "Greek Gods" to listOf(
            "Zeus", "Poseidon", "Hades", "Athena", "Apollo", "Artemis", "Hera",
            "Hermes", "Hephaestus", "Aphrodite", "Dionysus", "Demeter",
            "Ares", "Persephone", "Hestia", "Eros", "Hypnos", "Nike",
            "Pan", "Helios"
        ),
        "Famous Castles" to listOf(
            "Neuschwanstein Castle", "Windsor Castle", "Edinburgh Castle",
            "Alhambra", "Mont Saint-Michel", "Prague Castle", "Bran Castle",
            "Himeji Castle", "Versailles", "Château de Chambord",
            "Krak des Chevaliers", "Castle of the Teutonic Order",
            "Dover Castle", "Matsumoto Castle", "Eltz Castle",
            "Balmoral Castle", "Blarney Castle", "Château de Chillon",
            "Corfe Castle", "Leeds Castle"
        ),
        "Cartoon Characters" to listOf(
            "Mickey Mouse", "Bugs Bunny", "Scooby-Doo", "Tom", "Jerry", "Bart Simpson",
            "Homer Simpson", "SpongeBob SquarePants", "Daffy Duck", "Goofy",
            "Donald Duck", "Shaggy", "Fred Flintstone", "Yogi Bear",
            "Popeye", "Wile E. Coyote", "Road Runner", "Tweety", "Felix the Cat",
            "Garfield"
        ),
        "Famous Dancers" to listOf(
            "Michael Jackson", "Mikhail Baryshnikov", "Fred Astaire",
            "Ginger Rogers", "Gene Kelly", "Rudolf Nureyev", "Martha Graham",
            "Anna Pavlova", "Josephine Baker", "Patrick Swayze",
            "Beyoncé", "Shakira", "Britney Spears", "Chris Brown",
            "Isadora Duncan", "Sergei Polunin", "Savion Glover", "Alvin Ailey",
            "Maddie Ziegler", "Misty Copeland"
        ),
        "Gems and Minerals" to listOf(
            "Diamond", "Ruby", "Sapphire", "Emerald", "Amethyst", "Opal", "Topaz",
            "Quartz", "Turquoise", "Aquamarine", "Garnet", "Peridot", "Jade",
            "Onyx", "Amber", "Obsidian", "Moonstone", "Zircon", "Malachite",
            "Lapis Lazuli"
        ),
        "Mythical Creatures" to listOf(
            "Dragon", "Phoenix", "Unicorn", "Griffin", "Minotaur", "Mermaid",
            "Sphinx", "Kraken", "Chimera", "Hydra", "Basilisk", "Cerberus",
            "Werewolf", "Vampire", "Fairy", "Golem", "Centaur", "Pegasus",
            "Goblin", "Yeti"
        ),
        "Festivals Around the World" to listOf(
            "Carnival (Brazil)", "Diwali (India)", "Oktoberfest (Germany)",
            "Chinese New Year (China)", "Mardi Gras (USA)", "Holi (India)",
            "Day of the Dead (Mexico)", "Songkran (Thailand)", "Running of the Bulls (Spain)",
            "La Tomatina (Spain)", "St. Patrick’s Day (Ireland)",
            "Harbin Ice Festival (China)", "Cherry Blossom Festival (Japan)",
            "Eid al-Fitr (Islamic)", "Thanksgiving (USA)", "Christmas (Worldwide)",
            "Hanukkah (Judaism)", "Vesak (Buddhist)", "New Year’s Eve (Worldwide)",
            "Bastille Day (France)"
        ),
        "Wonders of the World" to listOf(
            "Great Wall of China", "Petra", "Christ the Redeemer", "Machu Picchu",
            "Chichen Itza", "Roman Colosseum", "Taj Mahal", "Giza Pyramids",
            "Angkor Wat", "Statue of Zeus", "Hanging Gardens of Babylon",
            "Temple of Artemis", "Pharos of Alexandria", "Lighthouse of Alexandria",
            "Stonehenge", "Acropolis of Athens", "Great Barrier Reef",
            "Victoria Falls", "Mount Everest", "Grand Canyon"
        )








    )
}
