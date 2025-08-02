# 🚦 Smart Traffic Light Network Simulation

[![Java](https://img.shields.io/badge/Java-8%2B-blue)](https://www.oracle.com/java/)
[![Platform](https://img.shields.io/badge/Platform-Desktop-lightgrey)]()
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

A simple Java-based project simulating a **smart traffic light network** using **client-server communication** and a **graphical interface**.

---

## ✨ Features
- **Traffic Light Controller** – Cycles through **Red → Green → Yellow** automatically.
- **Server-Client Communication** – Vehicle clients request the current traffic light state.
- **Graphical User Interface (GUI)** – Visual representation of the traffic light using Swing.
- **Beginner-Friendly** – Designed as a mini-project for learning **Computer Networks** and **Concurrency**.

---

## 📂 Project Structure
- `LightState.java` → Enum representing traffic light states (RED, YELLOW, GREEN)
- `TrafficController.java` → Controls traffic light state transitions
- `TrafficLightGUI.java` → Swing-based GUI to display the traffic light
- `TrafficLightServer.java` → Main server handling client requests
- `VehicleClient.java` → Simulates vehicles requesting traffic light state
- `VehicleHandler.java` → Handles communication for each connected vehicle

---

## 🛠 How It Works
1. **TrafficLightServer** starts and runs the traffic controller thread.
2. **TrafficLightGUI** displays the current light, updating automatically.
3. **VehicleClient** connects to the server and receives the current light state.

---

## 🚀 Getting Started

### Prerequisites
- Java 8 or newer
- Git (for cloning the repository)

### Steps to Run

### 1. Compile the Source Code
```bash
javac *.java
```

### 2. Start the Server
```bash
java TrafficLightServer
```

### 3. Run the GUI (Optional)
```bash
java TrafficLightGUI
```

### 4. Simulate a Vehicle Client
```bash
java VehicleClient
```

---

## 📺 Example Output

### Server Console
```yaml
Traffic Light changed to: RED  
Traffic Light changed to: GREEN  
Vehicle Request: Vehicle arrived
```

### Client Console
```yaml
Traffic Light State: GREEN
```

---

## 🔮 Future Improvements

- Configurable cycle timings and server port via external config file  
- Enhanced GUI to support multiple intersections  
- Priority handling for emergency vehicles  
- Use of thread pool for scalable vehicle client handling  

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Would you like help adding a project description, diagram, or contribution guidelines to make it even more complete?
