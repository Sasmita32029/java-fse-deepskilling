import officeImage from "./office.jpg";

function App() {

  const office = {
    name: "Smart Workspace",
    rent: 55000,
    address: "Hyderabad"
  };

  const officeList = [
    {
      name: "Smart Workspace",
      rent: 55000,
      address: "Hyderabad"
    },
    {
      name: "Tech Park",
      rent: 75000,
      address: "Bangalore"
    },
    {
      name: "Innovation Hub",
      rent: 62000,
      address: "Chennai"
    }
  ];

  return (
    <div style={{ margin: "20px" }}>
      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office"
        width="500"
      />

      <h2>Featured Office</h2>

      <p><strong>Name:</strong> {office.name}</p>

      <p>
        <strong>Rent:</strong>{" "}
        <span
          style={{
            color: office.rent < 60000 ? "red" : "green"
          }}
        >
          ₹{office.rent}
        </span>
      </p>

      <p><strong>Address:</strong> {office.address}</p>

      <hr />

      <h2>Available Office Spaces</h2>

      {officeList.map((item, index) => (
        <div
          key={index}
          style={{
            border: "1px solid black",
            padding: "10px",
            marginBottom: "10px",
            width: "350px"
          }}
        >
          <h3>{item.name}</h3>

          <p>
            <strong>Rent:</strong>{" "}
            <span
              style={{
                color: item.rent < 60000 ? "red" : "green"
              }}
            >
              ₹{item.rent}
            </span>
          </p>

          <p>
            <strong>Address:</strong> {item.address}
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;