import React, { Component } from "react";

class Modal extends Component {
  render() {
    return (
      <div>
        <div className="modalBg"></div>
        <div className="pop">
          <h2>Confirm</h2>
          <hr/>
          <span>Are you sure you want to delete employee detail with id: ¨{this.props.deleteId}</span>
          <div className="ButtonsContainer">
            <button className="ConfirmButton"
                  onclick={this.props.closeModal}>No</button>
            <button className="ConfirmButton"
                  onclick={this.props.handleDeleteEmployee}>Yes</button>
          </div>
        </div>
      </div>
    );
  }
}

export default Modal;
