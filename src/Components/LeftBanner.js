import React from "react";

function LeftBanner(props) {
  return (
    <div className="LeftBanner">
      <div className="AsideDiv">
        <div className="AsideHeader">
          <span className="AsideTitle">Add</span> <button className="ClearButton">Clear</button>
        </div>
        <hr />
        <form>
          <input type="text" placeholder="First Name" className="InputFields"/>
          <input type="text" placeholder="Last Name" className="InputFields"/>
          <select>
            <option value="0">--Select Department--</option>
          </select>
          <input type="number" placeholder="Salary per month" className="InputFields"/>
          <button className="AddButton">Add</button>
        </form>
      </div>

      <div className="AsideDiv">
        <div className="AsideHeader">
          <span className="AsideTitle">Filter & Sort</span> <button className="ClearButton">Clear</button>
        </div>
        <hr />
        <form>
          <select>
            <option value="0">--No filter--</option>
          </select>

          <select>
            <option value="0">--No sorting--</option>
          </select>
          <button className="AddButton">Filter</button>
        </form>
      </div>
    </div>
  );
}

export default LeftBanner;
