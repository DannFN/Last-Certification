import React from "react";

function LeftBanner(props) {
  const departments = ["Front-end", "Back-end", "Full-stack", "Testing"];


  return (
    <div className="LeftBanner">
      <div className="AsideDiv">
        <div className="AsideTitle">
          <span>Add</span> 
          <button className="ClearButton">Clear</button>
        </div> 
        <hr />
        <form>
          <input type="text" placeholder="First Name" className="InputFields"/>
          <input type="text" placeholder="Last Name" className="InputFields"/>
          <select>
            <option value="0">--Select Department--</option>
            {departments.map((department, index) => (
              <option key={index} value={index + 1}>
                {department}
              </option>
            ))}
          </select>
          <input type="number" placeholder="Salary per month" className="InputFields"/>
          <button className="AddButton">Add</button>
          <span id="ErrorMessage"></span>
        </form>
      </div>

      <div className="AsideDiv">
        <div className="AsideTitle">
          <span>Filter & Sort</span> 
          <button className="ClearButton">Clear</button>
        </div> 
        <hr />
        <form>
          <select>
            <option value="0">--No filter--</option>
            {departments.map((department, index) => (
              <option key={index} value={index + 1}>
                {department}
              </option>
            ))}
          </select>

          <select>
            <option value="0">--No sorting--</option>
            <option value="0">Low to High</option>
            <option value="0">High to Low</option>
          </select>
          <button className="AddButton">Filter</button>
        </form>
      </div>
    </div>
  );
}

export default LeftBanner;
