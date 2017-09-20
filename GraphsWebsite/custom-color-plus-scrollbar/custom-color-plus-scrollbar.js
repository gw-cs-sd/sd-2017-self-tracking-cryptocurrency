var config = {
        container: "#OrganiseChart1",
        rootOrientation:  'WEST', // NORTH || EAST || WEST || SOUTH
        // levelSeparation: 30,
        siblingSeparation:   20,
        subTeeSeparation:    60,
        scrollbar: "fancy",
        
        connectors: {
            type: 'step'
        },
        node: {
            HTMLclass: 'nodeExample1'
        }
    },
    root = {
        text: {
            name: "Color Schemes",
        },
        HTMLid: "root"
    },
    education = {
        HTMLclass: 'education',
        parent: root,
        text: {
            name: "Education",
        },
        HTMLid: "edu"
    },
        edu_StuLoans = {
            HTMLclass: 'edu-studentLoans',
            parent: education,
            text:{
                name: "Student Loans",
            },
            stackChildren: true,
            HTMLid: "stuLoans"
        },
        edu_tuition = {
            HTMLclass: 'edu-tuition',
            parent: education,
            text:{
                name: "Tuition",
            },

            HTMLid: "tuition"
        },
        edu_books = {
            HTMLclass: 'edu-books',
            parent: education,
            text:{
                name: "Books",

            },
            HTMLid: "books"
        },
        edu_supplies = {
            HTMLclass: 'edu-supplies',
            parent: education,
            text:{
                name: "Supplies",

            },
            HTMLid: "supplies"
        },
    entertainment = {
        HTMLclass: 'entertainment',
        parent: root, 
        text: {
            name: "entertainment",
        },
        HTMLid: "ent"
    },
        ent_arts = {
            HTMLclass: 'ent-arts',
            parent: entertainment,
            text:{
                name: "Arts",
            },
            stackChildren: true,
            HTMLid: "arts"
        },
        ent_music = {
            HTMLclass: 'ent-music',
            parent: entertainment,
            text:{
                name: "Music",
            },

            HTMLid: "music"
        },
        ent_movies = {
            HTMLclass: 'ent-movies',
            parent: entertainment,
            text:{
                name: "Movies",

            },
            HTMLid: "movies"
        },
        ent_newspaperMag = {
            HTMLclass: 'ent-newspaperMag',
            parent: entertainment,
            text:{
                name: "Newspaper / Magazines",

            },
            HTMLid: "news"
        },
        ent_sports = {
            HTMLclass: 'ent-sports',
            parent: entertainment,
            text:{
                name: "Sports",

            },
            HTMLid: "sports"
        },
    shopping = {
        HTMLclass: 'shopping',
        parent: root, 
        text: {
            name: "Shopping",
        },
        HTMLid: "shop"
    },
        shop_clothing = {
            HTMLclass: 'shop-clothing',
            parent: shopping,
            text:{
                name: "Clothing",
            },
            stackChildren: true,
            HTMLid: "cloth"
        },
        shop_books = {
            HTMLclass: 'shop-books',
            parent: shopping,
            text:{
                name: "Books",
            },
            HTMLid: "books"
        },
        shop_hobbies = {
            HTMLclass: 'shop-hobbies',
            parent: shopping,
            text:{
                name: "Hobbies",
            },
            HTMLid: "Hobbies"
        },
        shop_sports = {
            HTMLclass: 'shop-sports',
            parent: shopping,
            text:{
                name: "Sports",
            },
            HTMLid: "sport"
        },
    technology = {
        HTMLclass: 'technology',
        parent: root, 
        text: {
            name: "Technology",
        },
        HTMLid: "tech"
    },
        tech_software = {
            HTMLclass: 'tech-software',
            parent: technology,
            text:{
                name: "Software",
            },
            stackChildren: true,
            HTMLid: "software"
        },
        tech_products = {
            HTMLclass: 'tech-products',
            parent: technology,
            text:{
                name: "Products",
            },
            HTMLid: "products"
        },
        tech_electronics = {
            HTMLclass: 'tech-electronics',
            parent: technology,
            text:{
                name: "Electronics",
            },
            HTMLid: "electronics"
        },
    personalCare = {
        HTMLclass: 'personalCare',
        parent: root, 
        text: {
            name: "Personal Care",
        },
        HTMLid: "personal"
    },
        pers_laundry = {
            HTMLclass: 'pers-laundry',
            parent: personalCare,
            text:{
                name: "Laundry",
            },
            stackChildren: true,
            HTMLid: "laundry"
        },
        pers_hair = {
            HTMLclass: 'pers-hair',
            parent: personalCare,
            text:{
                name: "hair",
            },
            HTMLid: "hair"
        },
        pers_spa = {
            HTMLclass: 'pers-spaMassage',
            parent: personalCare,
            text:{
                name: "spaMassage",
            },
            HTMLid: "spa"
        },
        pers_sports = {
            HTMLclass: 'pers-sports',
            parent: personalCare,
            text:{
                name: "sports",
            },
            HTMLid: "sportsper"
        },
    healthFitness = {
        HTMLclass: 'healthFitness',
        parent: root, 
        text: {
            name: "Health Fitness",
        },
        HTMLid: "health"
    },
        health_dentist = {
            HTMLclass: 'health-dentist',
            parent: healthFitness,
            text:{
                name: "Dentist",
            },
            stackChildren: true,
            HTMLid: "dentist"
        },
        health_doctor = {
            HTMLclass: 'health-doctor',
            parent: healthFitness,
            text:{
                name: "Doctor",
            },
            HTMLid: "doctor"
        },
        health_eyecare = {
            HTMLclass: 'health-eyecare',
            parent: healthFitness,
            text:{
                name: "Eye Care",
            },
            HTMLid: "eyecare"
        },
        health_pharmacy = {
            HTMLclass: 'health-pharmacy',
            parent: healthFitness,
            text:{
                name: "Pharmacy",
            },
            HTMLid: "pharmacy"
        },
        health_healthInsurance = {
            HTMLclass: 'health-healthInsurance',
            parent: healthFitness,
            text:{
                name: "Health Insurance",
            },
            HTMLid: "healthInsurance"
        },
        health_gym = {
            HTMLclass: 'health-gym',
            parent: healthFitness,
            text:{
                name: "Gym",
            },
            HTMLid: "gym"
        },
        health_sports = {
            HTMLclass: 'health-sports',
            parent: healthFitness,
            text:{
                name: "Sports",
            },
            HTMLid: "sports"
        },
    kids = {
        HTMLclass: 'kids',
        parent: root, 
        text: {
            name: "Kids",
        },
        HTMLid: "kids"
    },
        kids_activities = {
            HTMLclass: 'kids-activities',
            parent: kids,
            text:{
                name: "Activities",
            },
            stackChildren: true,
            HTMLid: "activities"
        },
        kids_allowancs= {
            HTMLclass: 'kids-allowance',
            parent: kids,
            text:{
                name: "Allowance",
            },
            HTMLid: "allowance"
        },
        kids_babysupplies= {
            HTMLclass: 'kids-babysupplies',
            parent: kids,
            text:{
                name: "Baby Supplies",
            },
            HTMLid: "babysupplies"
        },
        kids_daycare= {
            HTMLclass: 'kids-daycare',
            parent: kids,
            text:{
                name: "Daycare",
            },
            HTMLid: "daycare"
        },
        kids_childSupport= {
            HTMLclass: 'kids-childSupport',
            parent: kids,
            text:{
                name: "Child Support",
            },
            HTMLid: "childSupport"
        },
        kids_toys= {
            HTMLclass: 'kids-toys',
            parent: kids,
            text:{
                name: "Toys",
            },
            HTMLid: "toys"
        },
    foodDining = {
        HTMLclass: 'foodDining',
        parent: root, 
        text: {
            name: "Food Dining",
        },
        HTMLid: "foodDining"
    },
        food_groceries = {
            HTMLclass: 'food-groceries',
            parent: foodDining,
            text:{
                name: "Groceries",
            },
            stackChildren: true,
            HTMLid: "groceries"
        },
        food_coffee = {
            HTMLclass: 'food-coffee',
            parent: foodDining,
            text:{
                name: "Coffee",
            },
            HTMLid: "coffee"
        },
        food_fastFood = {
            HTMLclass: 'food-fastFood',
            parent: foodDining,
            text:{
                name: "Fast Food",
            },
            HTMLid: "fastFood"
        },
        food_restaurants = {
            HTMLclass: 'food-resturants',
            parent: foodDining,
            text:{
                name: "Resturants",
            },
            HTMLid: "resturants"
        },
        food_alcoholBars = {
            HTMLclass: 'food-alcoholBars',
            parent: foodDining,
            text:{
                name: "Alcohol Bars",
            },
            HTMLid: "alcoholBars"
        },
        businessServices = {
            HTMLclass: 'businessServices',
            parent: root,
            text:{
                name: "Business Services",
            },
            HTMLid: "businessServices"
        },
        businessServices_legal = {
            HTMLclass: 'bus-legal',
            parent: businessServices,
            text:{
                name: "Legal",
            },
            HTMLid: "legal"
        },

  
    ALTERNATIVE = [
        config,
        root,
        education,
        edu_tuition,
        edu_StuLoans,
        edu_books,
        edu_supplies,
        entertainment,
        ent_arts,
        ent_music,
        ent_movies,
        ent_newspaperMag,
        ent_sports,
        shopping,
        shop_clothing,
        shop_books,
        shop_hobbies,
        shop_sports,
        technology,
        tech_software,
        tech_electronics,
        personalCare,
        pers_laundry,
        pers_hair,
        pers_spa,
        pers_sports,
        healthFitness,
        health_dentist,
        health_doctor,
        health_eyecare,
        health_pharmacy,
        health_healthInsurance,
        health_gym,
        health_sports,
        kids,
        kids_activities,
        kids_allowancs,
        kids_babysupplies,
        kids_daycare,
        kids_childSupport,
        kids_toys,
        foodDining,
        food_groceries,
        food_coffee,
        food_fastFood,
        food_restaurants,
        food_alcoholBars,
        businessServices,
        businessServices_legal
    ];