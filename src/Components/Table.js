import React from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { solid } from '@fortawesome/fontawesome-svg-core/import.macro'

function Table({ data, handleEdit, handleDelete}) {
  return (
    <div className="TableContainer">
      <table className="Table">
        <thead>
          <tr>
            <td>ID</td>
            <td>Employee Name</td>
            <td>Department</td>
            <td>Salary</td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          {data.map((employee) => (
            <tr key={employee._id}>
              <td>{employee._id}</td>
              <td>{employee.firstName} {employee.lastName}</td>
              <td>{employee.department}</td>
              <td>{employee.salary}</td>
              <td className="TableIcons">
                <FontAwesomeIcon icon={solid('pencil')} onClick={() => handleEdit(employee._id)}/>
                <FontAwesomeIcon icon={solid('trash-alt')} onClick={() => handleDelete(employee._id)}/>
              </td>
            </tr>
          ))}
          {
            data.length === 0 &&
            <tr>
              <td colSpan={5}><h2>No Employee Found</h2></td>
            </tr>
          }
        </tbody>
      </table>
    </div>
  );
}

export default Table;
