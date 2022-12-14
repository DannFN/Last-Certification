import React, { Component } from "react";
import "./App.css";
import LeftBanner from "./Components/LeftBanner";
import Table from "./Components/Table";
import Modal from "./Components/Modal";

class App extends Component {
  state = {
    data: [],
    firstName: undefined,
    lastName: undefined,
    department: undefined,
    salary: undefined,
    showModal: false,
    editId: undefined,
    mode: true,
    deleteId: undefined,
    sort: "none",
    filter: "none",
    errorMsg: "",
  };


  handleGetData = () => {
   
  };

  handleChange = (e) => {
    
  };

  handleResetState = () => {
    
  };

  handleClearFilter = () => {
    
  };

  //filter and sorting
  handleFilter = () => {
    
  };

  handleDelete = (i) => {
    
  };

  closeModal = () => {
    
  };

  handleEdit = (i) => {
    
  };

  handleDeleteEmployee = async (i) => {
    
  };

  handleValidation = () => {
    
  };

  handleAdd = async () => {
    
  };

  render() {
    return (
      <div>
        <header className="Header">
          Employee Management
        </header>
        <div className="Body">
          <LeftBanner />
          <Table />
        </div>
        <Modal />
      </div>
    );
  }
}

export default App;
