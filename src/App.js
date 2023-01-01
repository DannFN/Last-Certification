import React, { Component } from "react";
import "./App.css";
import LeftBanner from "./Components/LeftBanner";
import Table from "./Components/Table";
import Modal from "./Components/Modal";

class App extends Component {
  state = {
    data: [],
    mode: true,
    editId: undefined,
    deleteId: undefined,
    firstName: undefined,
    lastName: undefined,
    department: undefined,
    salary: undefined,
    showModal: false,
    sort: "none",
    filter: "none",
    errorMsg: "",
  };

  handleGetData = async () => {
    try {
      const res = await fetch("http://localhost:3000/employees");
      const data = await res.json();

      if (!res.ok) {
        throw new Error(data.description );
      }

      this.setState({ data });
    } catch (err) {
      console.log(err);
    }
  };

  handleChange = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
  };

  handleResetState = () => {
    this.setState({
      mode: true,
      editId: undefined,
      deleteId: undefined,
      firstName: undefined,
      lastName: undefined,
      department: undefined,
      salary: undefined,
      errorMsg: "",
    });
  };

  handleClearFilter = () => {
    this.setState({
      filter: "none",
      sort: "none",
    });
  };

  handleFilter = async () => {
    try {
      const res = await fetch(`http://localhost:3000/employees?filter=${this.state.filter}&sort=${this.state.sort}`);
      const data = await res.json();

      if (!res.ok) {
        throw new Error(data.description);
      }

      this.setState({ data });
    } catch (err) {
      console.log(err);
    }
  };

  handleDelete = async (i) => {
    this.setState({
      deleteId: i,
      showModal: true,
    });
  };

  closeModal = () => {
    this.setState({
      deleteId: undefined,
      showModal: false
    });
  };

  handleEdit = async (i) => {
    try {
      const res = await fetch(`http://localhost:3000/employees/${i}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          firstName: this.state.firstName,
          lastName: this.state.lastName,
          department: this.state.department,
          salary: this.state.salary,
        }),
      });

      const data = await res.json();

      if (!res.ok) {
        throw new Error(data.description);
      }

      this.setState({ data });
    } catch (err) {
      console.log(err);
    }
  };

  handleDeleteEmployee = async (i) => {
    try {
      const res = await fetch(`http://localhost:3000/employees/${i}`, { method: "DELETE", });
      const data = await res.json();

      if (!res.ok) {
        throw new Error(data.description);
      }

      this.setState({ 
        showModal: false,
        data: this.state.data.filter((employee) => employee.id !== i), 
      });
    } catch (err) {
      console.log(err);
    }
  };

  handleValidation = () => {
    // TODO: validation
  };

  handleAdd = async () => {
    const { firstName, lastName, department, salary } = this.state;

    this.handleValidation();

    const res = await fetch("http://localhost:3000/employees", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        firstName,
        lastName,
        department,
        salary,
      }),
    });

    const newEmployee = await res.json();
    
    this.setState({
      data: [...this.state.data, newEmployee],
    });
  };

  render() {
    return (
      <div>
        <header className="Header">
          Employee Management
        </header>
        <div className="Body">
          <LeftBanner 
            mode={this.state.mode}
            firstName={this.state.firstName}
            lastName={this.state.lastName}
            department={this.state.department}
            salary={this.state.salary}
            filter={this.state.filter}
            sort={this.state.sort}
            handleResetState={this.handleResetState}
            handleChange={this.handleChange}
            handleAdd={this.handleAdd}
            handleFilter={this.handleFilter}
            handleClearFilter={this.handleClearFilter}
          />
          <Table
            handleGetData={this.handleGetData} 
            data={this.state.data}
            handleEdit={this.handleEdit}
            handleDelete={this.handleDelete}
          />
        </div>
        <Modal 
          showModal={this.state.showModal}
          closeModal={this.closeModal}
          deleteId={this.state.deleteId}
          handleDeleteEmployee={this.handleDeleteEmployee}
        />
      </div>
    );
  }
}

export default App;
