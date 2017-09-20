var config = {
        container: "#custom-colored",

        nodeAlign: "BOTTOM",
        
        connectors: {
            type: 'step'
        },
        node: {
            HTMLclass: 'nodeExample1'
        }
    },
    cur01 = {
        HTMLclass: 'education',
        text: {
            name: "ID01",
            title: "Allocate Education",
            contact: "$1000.00 Balance Remaining: $0",
        },
        image: "headshots/edu.png",
    },
    cur02 = {
        parent: cur01,
        HTMLclass: 'edu-supplies',
        text:{
            name: "ID02",
            title: "Reallocate Supplies",
            contact: "$500.00 Balance Remaining: $43",
        },
        image: "headshots/edu.png",
    },
    cur03 = {
        parent: cur01,
        HTMLclass: 'edu-books',
        text:{
            name: "ID03",
            title: "Reallocate Books",
            contact: "$250.00 Balance Remaining: $0",
        },
        image: "headshots/edu.png",
    },
    cur04 = {
        parent: cur02,
        HTMLclass: 'edu-supplies',
        text:{
            name: "ID04",
            title: "Supplies Purchase",
            contact: "$457.00 Balance Remaining: $0",
        },
        image: "headshots/edu.png",
    },

    cur05 = {
        parent: cur03,
        HTMLclass: 'edu-books',
        text:{
            name: "ID05",
            title: "Reallocate Science Books",
            contact: "$457.00 Balance Remaining: $250",
        },
        image: "headshots/edu.png",
    },
    cur06 = {
        parent: cur04,
        HTMLclass: 'businessServices',
        text:{
            name: "ID06",
            title: "Business Services",
            contact: "$457.00 Balance Remaining: $457",
        },
        image: "headshots/bus.png",
    },
    cur07 = {
        parent: cur01,
        HTMLclass: 'edu-books',
        text:{
            name: "ID07",
            title: "Reallocate Books",
            contact: "$250.00 Balance Remaining: $0",
        },
        image: "headshots/edu.png",
    },
    cur08 = {
        parent: cur06,
        HTMLclass: 'bus-legal',
        text:{
            name: "ID08",
            title: "Reallocated Legal",
            contact: "$457.00 Balance Remaining: $457",
        },
        image: "headshots/bus.png",
    },
    cur09 = {
        parent: cur07,
        HTMLclass: 'edu-books',
        text:{
            name: "ID09",
            title: "Purchase Books",
            contact: "$57.97 Balance Remaining: $0",
        },
        image: "headshots/edu.png",
    },
    cur10 = {
        parent: cur07,
        HTMLclass: 'edu-books',
        text:{
            name: "ID10",
            title: "Purchase Books",
            contact: "$192.03 Balance Remaining: $0",
        },
        image: "headshots/edu.png",
    },
    cur10_root= {
        HTMLclass: 'edu-books',
        text:{
            name: "ID10",
            title: "Purchase Books",
            contact: "$192.03 Balance Remaining: $0",
        },
        image: "headshots/edu.png",
    },
    cur11 = {
        parent: cur09,
        HTMLclass: 'businessServices',
        text:{
            name: "ID11",
            title: "Business Services",
            contact: "$57.97 Balance Remaining: $26.74",
        },
        image: "headshots/bus.png",
    },
    cur12 = {
        parent: cur10,
        HTMLclass: 'businessServices',
        text:{
            name: "ID12",
            title: "Business Services",
            contact: "$192.03 Balance Remaining: $25.86",
        },
        image: "headshots/bus.png",
    },
    cur12_root = {
        parent: cur10_root,
        HTMLclass: 'businessServices',
        text:{
            name: "ID12",
            title: "Business Services",
            contact: "$192.03 Balance Remaining: $25.86",
        },
        image: "headshots/bus.png",
    },
    cur13 = {
        parent: cur05,
        HTMLclass: 'edu-books',
        text:{
            name: "ID13",
            title: "Purchase Biology Books",
            contact: "$250.00 Balance Remaining: $0",
        },
        image: "headshots/edu.png",
    },
    cur14 = {
        parent: cur11,
        HTMLclass: 'businessServices',
        text:{
            name: "ID14",
            title: "Supplies Purchase",
            contact: "$31.23 Balance Remaining: $0",
        },
        image: "headshots/bus.png",
    },

    cur15 = {
        parent: cur12,
        HTMLclass: 'bus-salary',
        text:{
            name: "ID15",
            title: "Cashier Salary",
            contact: "$73.89 Balance Remaining: $250",
        },
        image: "headshots/bus.png",
    },
    cur15_root = {
        parent: cur12_root,
        HTMLclass: 'bus-salary',
        text:{
            name: "ID15",
            title: "Cashier Salary",
            contact: "$73.89 Balance Remaining: $250",
        },
        image: "headshots/bus.png",
    },
    cur16 = {
        parent: cur12,
        HTMLclass: 'bus-legal',
        text:{
            name: "ID16",
            title: "Legal Expenses",
            contact: "$92.28 Balance Remaining: $92.28",
        },
        image: "headshots/bus.png",
    },
    cur16_root = {
        parent: cur12_root,
        HTMLclass: 'bus-legal',
        text:{
            name: "ID16",
            title: "Legal Expenses",
            contact: "$92.28 Balance Remaining: $92.28",
        },
        image: "headshots/bus.png",
    },
    cur17 = {
        parent: cur13,
        HTMLclass: 'health-healthInsurance',
        text:{
            name: "ID17",
            title: "Allocated to Health Insurance",
            contact: "$250.00 Balance Remaining: $250",
        },
        image: "headshots/fitness.png",
    },
    cur18 = {
        parent: cur14,
        HTMLclass: 'technology',
        text:{
            name: "ID18",
            title: "Allocated Technology",
            contact: "$31.23 Balance Remaining: $27.22",
        },
        image: "headshots/tech.png",
    },
    cur19 = {
        parent: cur18,
        HTMLclass: 'tech-electronics',
        text:{
            name: "ID19",
            title: "Purchase Application",
            contact: "$3.99 Balance Remaining: $3.99",
        },
        image: "headshots/tech.png",
    },
    cur20 = {
        parent: cur17,
        HTMLclass: 'health-healthInsurance',
        text:{
            name: "ID20",
            title: "Purchase Health Insurance",
            contact: "$250.00 Balance Remaining: $00",
        },
        image: "headshots/fitness.png",
    },
    cur21 = {
        parent: cur13,
        HTMLclass: 'businessServices',
        text:{
            name: "ID21",
            title: "Business Services",
            contact: "$57.97 Balance Remaining: $5.94",
        },
        image: "headshots/bus.png",
    },
    cur22 = {
        parent: cur20,
        HTMLclass: 'health-doctor',
        text:{
            name: "ID22",
            title: "Allocate to Doctors",
            contact: "$250.00 Balance Remaining: $133.16",
        },
        image: "headshots/doc.png",
    },
    cur23 = {
        parent: cur22,
        HTMLclass: 'health-doctor',
        text:{
            name: "ID23",
            title: "Doctor Appointment Co-Pay",
            contact: "$43.75 Balance Remaining: $0",
        },
        image: "headshots/doc.png",
    },
    cur24 = {
        parent: cur16,
        HTMLclass: 'health-gym',
        text:{
            name: "ID24",
            title: "Allocate Employee Gym",
            contact: "$92.28 Balance Remaining: $9.07",
        },
        image: "headshots/fitness.png",
    },
    cur24_root = {
        parent: cur16_root,
        HTMLclass: 'health-gym',
        text:{
            name: "ID24",
            title: "Allocate Employee Gym",
            contact: "$92.28 Balance Remaining: $9.07",
        },
        image: "headshots/fitness.png",
    },

    cur25 = {
        parent: cur21,
        HTMLclass: 'businessServices',
        text:{
            name: "ID25",
            title: "Purchase Paper",
            contact: "$52.03 Balance Remaining: $52.03",
        },
        image: "headshots/bus.png",
    },
    cur26 = {
        parent: cur22,
        HTMLclass: 'health-doctor',
        text:{
            name: "ID26",
            title: "Surgery Co-Pay",
            contact: "$73.09 Balance Remaining: $73.09",
        },
        image: "headshots/doc.png",
    },
    cur27 = {
        parent: cur23,
        HTMLclass: 'bus-salary',
        text:{
            name: "ID27",
            title: "Doctor Hourly Salary",
            contact: "$43.75 Balance Remaining: $23.75",
        },
        image: "headshots/bus.png",
    },
    cur28 = {
        parent: cur27,
        HTMLclass: 'kids-allowance',
        text:{
            name: "ID28",
            title: "Kids Allowance",
            contact: "$20.00 Balance Remaining: $20.00",
        },
        image: "headshots/kids.png",
    },
    cur29 = {
        parent: cur24,
        HTMLclass: 'health-gym',
        text:{
            name: "ID29",
            title: "Weights Purchase",
            contact: "$83.21 Balance Remaining: $83.21",
        },
        image: "headshots/edu.png",
    },
    cur29_root = {
        parent: cur24_root,
        HTMLclass: 'health-gym',
        text:{
            name: "ID29",
            title: "Weights Purchase",
            contact: "$83.21 Balance Remaining: $83.21",
        },
        image: "headshots/edu.png",
    },
    cur30 = {
        parent: cur28,
        HTMLclass: 'food-fastFood',
        text:{
            name: "ID30",
            title: "Purchase Icecream",
            contact: "$5.03 Balance Remaining: $14.97",
        },
        image: "headshots/food.png",
    },


    chart_config = [
        config,
        cur01, 
        cur02, 
        cur03,
        cur04, 
        cur05, 
        cur06,
        cur07, 
        cur08, 
        cur09,
        cur10,
        cur11,
        cur12,
        cur13,
        cur14, 
        cur15, 
        cur16,
        cur17, 
        cur18, 
        cur19,
        cur20,
        cur21,
        cur22,
        cur23,
        cur24, 
        cur25, 
        cur26,
        cur27, 
        cur28, 
        cur29,
        cur30
    ];

    chart_config1= [
        config,
        cur10_root,
        cur12_root,
        cur15_root,
        cur16_root,
        cur24_root,
        cur29_root
    ];
